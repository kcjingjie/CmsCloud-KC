package com.kc.es.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.kc.es.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


/**
 * 测试
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public void getData(String keyword){
        try {
            testService.getData(keyword);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
