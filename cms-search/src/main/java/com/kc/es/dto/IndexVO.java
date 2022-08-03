package com.kc.es.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


@Data
@AllArgsConstructor
public class IndexVO {
    private Long id;
    private String title;
    private String photo_url;
    private Integer read;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    private String source;
    private Integer comment_count;
}
