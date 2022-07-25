package com.kc.portal.entity.vo;

import lombok.Data;

/**
 * UserInfoVO
 *
 * @author KC
 * @date 2020/11/3
 */
@Data

public class UserInfoVO {
    private String openid;
    private Long avatar_id;
    private Long id;
    private String avatar_url;
    private String mobile;
    private String nickname;
    private Integer sex;
    private Integer status;
}
