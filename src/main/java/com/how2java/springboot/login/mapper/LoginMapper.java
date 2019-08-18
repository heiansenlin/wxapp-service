package com.how2java.springboot.login.mapper;

import com.how2java.springboot.login.entity.Login;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select uuid,openId,username,password,sessionKey from login_table where openId = #{openId}")
    Login getByOpenId(@Param("openId") String openId);

    @Insert("insert into login_table (uuid,openId,username,password,sessionKey) values (#{l.uuid},#{l.openId},#{l.username},#{l.password},#{l.sessionKey})")
    int save(@Param("l") Login login);
}
