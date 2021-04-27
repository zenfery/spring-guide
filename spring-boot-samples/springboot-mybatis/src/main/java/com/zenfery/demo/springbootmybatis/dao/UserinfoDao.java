package com.zenfery.demo.springbootmybatis.dao;

import com.zenfery.demo.springbootmybatis.model.Userinfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserinfoDao {

    @Insert("insert into userinfo(name, age) values(#{name}, #{age})")
    public void insert(Userinfo userinfo);

    @Select("select * from userinfo where id = #{id}")
    public Userinfo select(Long id);
}
