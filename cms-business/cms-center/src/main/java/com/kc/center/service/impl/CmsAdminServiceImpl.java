package com.kc.center.service.impl;

import com.kc.center.service.AuthService;
import com.kc.center.service.CmsAdminService;
import com.kc.common.entity.cms.UserDto;
import com.kc.common.model.Result;
import com.kc.common.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kc
 * CmsAdminService实现类
 */
@Service
public class CmsAdminServiceImpl implements CmsAdminService {

    @Autowired
    private AuthService authService;

    @Autowired
    private CmsAdminService adminService;

    @Override
    public Result login(String username, String password) {
        if (ValidatorUtils.isEmpty(username) || ValidatorUtils.isEmpty(password)){

        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id","client_1");
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        Map result = authService.getAccessToken(params);
        return null;
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        UserDto userDto = new UserDto();
        userDto.setUsername("ly");
        userDto.setPassword("123456");
        return null;
    }


}
