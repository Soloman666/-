package com.example.service.impl;

import com.example.mapper.GoodsMapper;

import com.example.pojo.Goods;
import com.example.pojo.Users;
import com.example.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public List<Goods> list() {
        return goodsMapper.list();
    }

    @Override
    public void delete(Integer number) {
        goodsMapper.deleteByNumber(number);
    }

    @Override
    public void save(Goods goods) {
        goodsMapper.insert(goods);
    }

    @Override
    public void updatestate(Goods goods) {
        goodsMapper.updatestate(goods);

    }

    @Override
    public Goods getByNumber(Integer number) {
        return goodsMapper.getByNumber(number);
    }

    @Override
    public void addMyGood(Goods goods,Integer id,String myaccount) {
        goodsMapper.insertMyGood(goods,id,myaccount);
    }

    @Override
    public List<Goods> getByName(String goodname) {
        return goodsMapper.getByName(goodname);
    }

    @Override
    public void updatestate2(Integer number) {
        goodsMapper.updatestate2(number);
    }


}
