package com.how2java.springboot.address.mapper;

import com.how2java.springboot.address.entity.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("select * from address_table where userid = #{userid}")
    List<Address> findAllByOpenId(@Param("userid") String userid);

    @Insert("insert into address_table (id,address,userid,province,city,country)" +
            " values (#{a.id},#{a.address},#{a.userid},#{a.province},#{a.city},#{a.country})")
    int save (@Param("a") Address address);

    @Select("select * from address_table where id = #{id}")
    Address getById(String id);
}
