package com.kc.portal.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 测试分库分表的mapper
 */
@Mapper
public interface UserMapper {

    @Select("select *  from t_user where id =2")
    Map selectUserList();

    @Insert("insert into t_user(name,city_id) values ('llllllhhhh',2)")
    void insetUser();

    @Select("select *  from user_info")
    List<Map> selectUserInfo();

    @Select("select count(*) from t_user")
    int selectCount();

}
