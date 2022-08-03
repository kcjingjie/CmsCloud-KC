package com.kc.es.test;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import com.kc.es.dto.IndexVO;
import com.kc.es.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEs {

    @Autowired
    private ElasticsearchClient client;

   @Autowired
   private DataSource dataSource;

    @Test
    public void test() throws IOException {
        GetResponse getResponse = client.get(a -> a.index("newapi").id("3002"), User.class);
        System.out.println("result = " + getResponse.source());

        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.remove("test");

        ArrayList<Object> objects = new ArrayList<>();

    }

    @Test
    public void testInsert() throws IOException {
        // 模糊查询
        SearchResponse<User> response8 = client.search(s -> s
                        .index("newapi")
                        .query(q -> q
                                .fuzzy(f -> f
                                        .field("username")
                                        .value("lisi")
                                        .fuzziness("1"))
                        )
                , User.class);
        System.out.println(response8.took());
        System.out.println(response8.hits().total().value());
        response8.hits().hits().forEach(e -> System.out.println(e.source().toString()));

    }

    @Test
    public void insertDocs() throws SQLException, IOException {

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from content_info");
        while (resultSet.next()){

            // 构建一个批量操作BulkOperation的集合
            List<BulkOperation> bulkOperations = new ArrayList<>();
            // 向集合添加数据
            try {
                String title = resultSet.getString("title");
                String photo_url = resultSet.getString("photo_url");
                int read = resultSet.getInt("read");
                String create_time = resultSet.getString("create_time");
                String source = resultSet.getString("source");
                resultSet.getString("source");
                bulkOperations.add(new BulkOperation.Builder().create(d-> {
                    return d.document(new IndexVO(1000,"",,,"",30)).id(String.valueOf(resultSet.getString("test"))).index("newapi");

                }).build());
            }catch (Exception e){

            }

            // 使用bulk方法执行批量操作并获得响应
            BulkResponse response = client.bulk(e->e.index("newapi").operations(bulkOperations));
            // 打印结果
            System.out.println(response.took());
            System.out.println(response.items());

        }

        statement.close();
        connection.close();




    }




}
