package com.kc.portal.entity.dto;

import lombok.Data;

/**
 * IndexListDTo
 *
 * @author KC
 * @date 2020/11/2
 */
@Data
public class IndexListDTO {

    private Long category_id;
    private Integer page_index;
    private Integer page_size;
    private String keyword;

}
