package com.kc.es.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortalEsController {

    @Autowired
    private ElasticsearchClient client;

    @PostMapping("getIndex")
    public Object getIndex(@RequestParam(required = false) Long category_id, @RequestParam Integer page_index, @RequestParam Integer page_size, @RequestParam(required = false) String keyword) {



        return  null;
    }









}
