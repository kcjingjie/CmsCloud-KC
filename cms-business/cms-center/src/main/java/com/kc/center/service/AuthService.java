package com.kc.center.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author kc
 * 认证服务远程调用
 */
@FeignClient("cms-auth-server")
public interface AuthService {

    @PostMapping(value = "/oauth/token")
    Map getAccessToken(@RequestParam Map<String,String> parameters);


}
