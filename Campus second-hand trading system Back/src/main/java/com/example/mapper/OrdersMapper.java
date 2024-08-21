package com.example.mapper;

import com.example.pojo.Orders;
import com.example.pojo.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface OrdersMapper {
    @Select("select * from orders where account = #{account}")
    List<Orders> list(String account);

    @Insert("insert into orders(account, selleraccount, goodname, date) "+
    "values (#{account},#{selleraccount},#{goodname},#{now})")
    void insert(String account, String goodname, String selleraccount, LocalDateTime now);

    @Select("select * from orders")
    List<Orders> alllist();

    @Delete("delete from orders where ordernum=#{ordernum}")
    void deleteByOrdernum(Integer ordernum);
}
