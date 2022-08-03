package com.kc.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认降级处理
 */
@RestController
public class DefaultHystrixController {
    @RequestMapping("/defaultfallback")
    public Map<String,Object> defaultfallback(){
        System.out.println("降级操作...");
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","服务异常");
        map.put("data","null");
        return map;
    }
}