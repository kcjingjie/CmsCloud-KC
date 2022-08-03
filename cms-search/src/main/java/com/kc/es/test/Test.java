package com.kc.es.test;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import com.kc.es.dto.User;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 */
public class Test {


        public static void main(String[] args) throws Exception{

        // 创建客户端连接部分
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());
        ElasticsearchClient client = new ElasticsearchClient(transport);

        // 构建一个批量操作BulkOperation的集合
        List<BulkOperation> bulkOperations = new ArrayList<>();
        // 向集合添加数据
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("zhangsan", "男", 30)).id("3001").index("newapi")).build());
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("lisi", "女", 30)).id("3002").index("newapi")).build());
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("wangwu", "男", 40)).id("3003").index("newapi")).build());
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("wangwu1", "女", 40)).id("3004").index("newapi")).build());
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("wangwu2", "男", 50)).id("3005").index("newapi")).build());
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("wangwu3", "男", 50)).id("3006").index("newapi")).build());
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("wangwu33", "男", 50)).id("3007").index("newapi")).build());
        bulkOperations.add(new BulkOperation.Builder().create(d-> d.document(new User("wangwu333", "男", 50)).id("3008").index("newapi")).build());
        // 使用bulk方法执行批量操作并获得响应
        BulkResponse response = client.bulk(e->e.index("newapi").operations(bulkOperations));
        // 打印结果
        System.out.println(response.took());
        System.out.println(response.items());

        // 关闭客户端连接部分
        transport.close();
        restClient.close();



    }




}
