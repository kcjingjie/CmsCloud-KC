package com.kc.portal.mapper;

import com.kc.portal.entity.vo.FavoriteVO;
import com.kc.portal.entity.vo.IndexVO;
import com.kc.portal.entity.vo.SliderVO;
import com.kc.portal.entity.vo.DetailVO;
import com.kc.portal.model.ContentInfo;
import com.kc.portal.utils.MyBaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
@CacheNamespace(flushInterval = 300000L)//缓存五分钟过期
public interface ContentInfoMapper extends MyBaseMapper<ContentInfo> {
    List<IndexVO> getIndex(@Param("category_id") Long category_id, @Param("q") String q);

    List<SliderVO> getSlider(@Param("category_id") Long category_id, @Param("q") String q);

    DetailVO getById(Long id);

    List<FavoriteVO> getFavoriteList(Long userId);

    @Update("UPDATE content_info set comment_count=comment_count+(#{count}) where id=#{id}")
    int addCommentCount(@Param("count") Integer count, @Param("id") Long id);

    @Update("UPDATE content_info set like_count=like_count+(#{count}) where id=#{id}")
    int addLikeCount(@Param("count") Integer count, @Param("id") Long id);

    @Update("UPDATE content_info set `read_count`=`read_count`+1 where id=#{id}")
    int addRead(Long id);
}
