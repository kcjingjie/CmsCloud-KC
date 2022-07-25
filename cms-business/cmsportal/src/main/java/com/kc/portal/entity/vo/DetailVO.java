package com.kc.portal.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kc.portal.entity.PageInfo;
import lombok.Data;

import java.util.Date;

/**
 * DetailVO
 *
 * @author KC
 */
@Data
public class DetailVO {

    private Long id;
    private String title;
    private int read;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    private String source;
    private Integer category_id;
    private String content;
    private Integer like_count;
    private Integer is_like;
    private Integer is_favorite;
    private PageInfo<CommentVO> comment;

}
