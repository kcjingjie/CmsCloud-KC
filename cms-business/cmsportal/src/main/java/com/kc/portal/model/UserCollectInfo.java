package com.kc.portal.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * UserInfo
 *
 * @author KC
 * @date 2020/11/3
 */
@Data
@Table(name = "user_collect_info")
public class UserCollectInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long user_id;
    private Integer type;
    private Long c_id;
    @Transient
    private Date create_time;
}
