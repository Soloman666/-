package com.example.mapper;

import com.example.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface AdminMapper {

     @Select("select * from administrator where admin=#{admin} and password=#{password}")
      Admin getByAdminAndPassword(Admin admin);
}
