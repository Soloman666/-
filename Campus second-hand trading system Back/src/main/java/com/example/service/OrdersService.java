package com.example.service;

import com.example.pojo.Orders;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface OrdersService {
     void delete(Integer ordernum) ;

    List<Orders> mylist(String account);

    void insert(String account, String goodname, String selleraccount, LocalDateTime now);

    List<Orders> alllist();
}
