package com.example.mapper;

import com.example.pojo.Goods;
import com.example.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goods where state = '未售'")
    List<Goods> list();

    @Delete("delete from goods where number=#{number}")
    void deleteByNumber(Integer number);


    @Insert("insert into goods(sellerid,selleraccount,goodname,prize,place,fineness) " +
            "values (#{sellerid},#{selleraccount},#{goodname},#{prize},#{place},#{fineness})")
    void insert(Goods goods);



    void updatestate(Goods goods);

    @Select("select * from goods where number=#{number}")
    Goods getByNumber(Integer number);



    @Insert("insert into goods(sellerid,selleraccount,goodname,prize,place,fineness)"+
            "values  (#{id},#{myaccount},#{goods.goodname},#{goods.prize},#{goods.place},#{goods.fineness})")
    void insertMyGood(Goods goods, Integer id, String myaccount);


    @Select("select * from goods where goodname=#{goodname} and state='未售'")
   List<Goods> getByName(String goodname);

    void updatestate2(Integer number);
}
