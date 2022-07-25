package com.kc.portal.entity.vo;

import lombok.Data;

/**
 * RegisterVO
 *
 * @author KC
 * @date 2020/11/3
 */
@Data
public class LoginVO {
    private Long user_id;
    private String mobile;
    private String nickname;
    private String avatar_url;
    private String token;
}
