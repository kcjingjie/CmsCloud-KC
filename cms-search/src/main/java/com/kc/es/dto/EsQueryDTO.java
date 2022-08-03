package com.kc.es.dto;

import lombok.Data;

@Data
public class EsQueryDTO {
    private String indexName;
    private String field;
    private String word;
    private Integer from;
    private Integer size;
 
    public Integer getSize() {
        return size==0?30:size;
    }
}