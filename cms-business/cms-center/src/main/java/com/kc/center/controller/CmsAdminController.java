package com.kc.center.controller;

import com.kc.center.service.CmsAdminService;
import com.kc.common.entity.cms.UserDto;
import com.kc.common.model.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台用户管理
 */
@Controller
@Api(value = "UmsAdminController",description = "用户后台管理")
public class CmsAdminController {

    @Autowired
    private CmsAdminService adminService;

    @ApiOperation(value = "用户登陆")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(String username,String password){
       return adminService.login(username,password);
    }

    @ApiOperation("根据用户名获取通用用户信息")
    @RequestMapping(value = "/loadByUsername", method = RequestMethod.GET)
    @ResponseBody
    public UserDto loadUserByUsername(@RequestParam String username) {
        UserDto userDTO = adminService.loadUserByUsername(username);
        return userDTO;
    }

}
