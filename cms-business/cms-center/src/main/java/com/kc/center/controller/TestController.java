package com.kc.center.controller;

import com.kc.common.redis.template.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试controller
 */
@RestController
public class TestController {

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/test")
    public String getTestData(){

        String test = redisUtil.get("test");
        return test;
    }



}
