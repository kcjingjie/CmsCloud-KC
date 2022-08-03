package com.kc.es.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticSearchConfig {
 
    @Value("${spring.elasticsearch.rest.host}")
    private String host;
    @Value("${spring.elasticsearch.rest.enable:true}")
    private boolean enable;
 
    @Value("${spring.elasticsearch.rest.port}")
    private int port;
    @Value("${spring.elasticsearch.rest.username}")
    private String userName;
 
    @Value("${spring.elasticsearch.rest.password}")
    private String passWord;
 
 
    //注入IOC容器
    @Bean
    public ElasticsearchClient elasticsearchClient(){
        ElasticsearchClient client = new ElasticsearchClient(null);
        if (enable){
            RestClient restClient = RestClient.builder(new HttpHost(host, port)).build();
 
            ElasticsearchTransport transport = new RestClientTransport(restClient,new JacksonJsonpMapper());
            // And create the API client
            client = new ElasticsearchClient(transport);
        }
        return client;
 
    }



}