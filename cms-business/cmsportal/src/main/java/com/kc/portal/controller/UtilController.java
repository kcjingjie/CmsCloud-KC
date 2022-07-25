package com.kc.portal.controller;

import com.kc.common.redis.template.RedisUtil;
import com.kc.portal.entity.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author kc
 */
@RestController
@RequestMapping("/util/")
public class UtilController {

    @Autowired
    RedisUtil redisUtil;


    @PostMapping("sendCode")
    public List<CommonVO> sendVerifyCode(String phone) {

        String code="1234";


        return null;
    }

    @GetMapping("getKeyValue")
    public String  getKeyValue(String key) {

        String code="1234";

        String s = redisUtil.get(key);

        if (s == null){

        }

        return s;
    }



}
