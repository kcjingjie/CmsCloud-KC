package com.kc.es.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import com.kc.es.dto.User;
import com.kc.es.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private ElasticsearchClient client;

    @Override
    public void getData(String keyword) throws IOException {
        GetResponse getResponse = client.get(a -> a.index("good_spu").id("1"), User.class);
        System.out.println("result = " + getResponse.source());
        client.sql();
    }
}
