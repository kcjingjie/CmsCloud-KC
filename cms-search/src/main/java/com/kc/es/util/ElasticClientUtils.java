package com.kc.es.util;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.CountResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.alibaba.fastjson.JSON;
import com.kc.es.dto.EsQueryDTO;


import java.io.IOException;
import java.util.*;
 
/**
 * @author kcjingjie
 * @title: ElasticClientUtils
 */
public class ElasticClientUtils<T> {
 
    /**
     * @author liuch
     * @description 根据关键字分页查询
     * @date 2022/4/2 17:15
     * @param 
     * @param client
     * @param dto
     * @param target 
     * @return java.util.List<T>
     */
    public List<T> queryByFiled(ElasticsearchClient client, EsQueryDTO dto, Class<T> target) throws Exception {
        List<T> result = new ArrayList<>();
        SearchResponse<HashMap> search = client.search(s -> s
                        .index(dto.getIndexName())
                        .query(q -> q.term(t -> t
                                .field(dto.getField())
                                .value(dto.getWord())
                        )).from(dto.getFrom()).size(dto.getSize()),
                HashMap.class);
        List<Hit<HashMap>> hits = search.hits().hits();
        Iterator<Hit<HashMap>> iterator = hits.iterator();
        while (iterator.hasNext()){
            Hit<HashMap> decodeBeanHit = iterator.next();
            Map<String,Object> docMap = decodeBeanHit.source();
            String json = JSON.toJSONString(docMap);
            T obj  = JSON.parseObject(json,target);
            result.add(obj);
        }
        return result;
    }
 
 
    /**
     * @author liuch
     * @description 根据关键字查询总条数
     * @date 2022/4/2 17:15
     * @param 
     * @param client
     * @param dto 
     * @return long
     */
    public long queryCountByFiled(ElasticsearchClient client, EsQueryDTO dto) throws Exception {
        CountResponse count = client.count(c -> c.index(dto.getIndexName()).query(q -> q.term(t -> t
                .field(dto.getField())
                .value(dto.getWord())
        )));
        long total = count.count();
        return total;
    }

    /**
     * @author liuch
     * @description 根据文档id查询
     * @date 2022/4/2 17:16
     * @param 
     * @param client
     * @param dto
     * @param target 
     * @return java.lang.Object
     */
    public Object queryByDocumentId(ElasticsearchClient client, EsQueryDTO dto,Class<T> target) throws Exception {
        GetResponse<HashMap> getResponse = client.get(s -> s
                        .index(dto.getIndexName()).id(dto.getWord()),
                HashMap.class);
        getResponse.source();
        Map<String,Object> docMap = getResponse.source();
        String json = JSON.toJSONString(docMap);
        T obj  = JSON.parseObject(json,target);
        return obj;
    }
 
}