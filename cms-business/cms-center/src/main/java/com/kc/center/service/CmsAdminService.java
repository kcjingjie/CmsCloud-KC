package com.kc.center.service;

import com.kc.common.entity.cms.UserDto;
import com.kc.common.model.Result;

/**
 * @author kc
 * 后台管理员Service
 */
public interface CmsAdminService {

    Result login(String username,String password);

    UserDto loadUserByUsername(String username);



}
