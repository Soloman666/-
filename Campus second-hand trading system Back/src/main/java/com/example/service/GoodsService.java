package com.example.service;

import com.example.pojo.Goods;
import com.example.pojo.Users;

import java.util.List;

public interface GoodsService {
    List<Goods> list();

    void delete(Integer number);

    void save(Goods goods);


    void updatestate(Goods goods);

    Goods getByNumber(Integer number);

    void addMyGood(Goods goods,Integer id,String myaccount);

    List<Goods> getByName(String goodname);

    void updatestate2(Integer number);
}
