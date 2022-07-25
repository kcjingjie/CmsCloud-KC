package com.kc.portal.entity.vo;

import com.kc.portal.entity.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * IndexListVO
 *
 * @author KC
 * @date 2020/11/2
 */
@Getter
@Setter
public class IndexListVO extends PageInfo<IndexVO> {
    private List<SliderVO> slider;

    public IndexListVO(Long count, Integer page, List<IndexVO> list, List<SliderVO> slider) {
        super(count, page, list);
        this.slider = slider;
    }
}
