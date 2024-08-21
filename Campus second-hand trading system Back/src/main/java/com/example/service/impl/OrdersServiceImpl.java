package com.example.service.impl;

import com.example.mapper.OrdersMapper;
import com.example.mapper.UsersMapper;
import com.example.pojo.Orders;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public void delete(Integer ordernum) {
        ordersMapper.deleteByOrdernum(ordernum);
    }

    @Override
    public List<Orders> mylist(String account) {
        return ordersMapper.list(account);
    }

    @Override
    public void insert(String account, String goodname, String selleraccount, LocalDateTime now) {
      ordersMapper.insert(account,goodname,selleraccount,now);
    }

    @Override
    public List<Orders> alllist() {
        return ordersMapper.alllist();
    }
}
