package com.example.mapper;

import com.example.pojo.Goods;
import com.example.pojo.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> list();

    @Delete("delete from users where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into users(account, password, grade, balance) " +
            "values (#{account},#{password},#{grade},#{balance})")
    void insert(Users users);

    @Select("select * from users where id = #{id}")
    Users getById(Integer id);

    void update(Users users);

    @Select("select * from users where account=#{account} and password=#{password}")
    Users getByaccountAndPassword(Users users);

    @Select("select * from goods where selleraccount = #{account}")
    List<Goods> myList(String account);

    @Insert("insert into users(account, password, grade) " +
            "values (#{account},#{password},#{grade})")
    void register(Users users);

    @Select("select * from goods where selleraccount = #{account} and state = '未交付'")
    List<Goods> undeliveredList(String account);
}


