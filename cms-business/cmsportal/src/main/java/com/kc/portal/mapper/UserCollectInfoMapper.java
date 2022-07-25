package com.kc.portal.mapper;

import com.kc.portal.model.UserCollectInfo;
import com.kc.portal.utils.MyBaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserCollectInfoMapper extends MyBaseMapper<UserCollectInfo> {
    @Select("select * from user_collect_info where c_id=#{comment_id} and type=#{type} and user_id=#{userId}")
    UserCollectInfo getByIdAndType(@Param("comment_id") Long comment_id, @Param("type") Integer type, @Param("userId") Long userId);
}
