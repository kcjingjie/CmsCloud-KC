package com.kc.portal.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * LinkVO
 *
 * @author KC
 * @date 2020/11/2
 */
@Data
/*
@NoArgsConstructor
*/
@AllArgsConstructor
public class LinkVO {
    private String type = "article";
    private Long id;
    private String url = "";

    public LinkVO(Long id) {
        this.id = id;
    }
}
