package com.example.service;

import com.example.pojo.Goods;
import com.example.pojo.Users;

import java.util.List;

public interface UsersService {
     Users login(Users users);


    //    查询全部用户数据
    List<Users> list() ;

    void delete(Integer id);

    void save(Users users);

    Users getById(Integer id);

    void update(Users users);

    List<Goods> myList(String account);

    void register(Users users);

    List<Goods> undeliveredList(String account);
}


