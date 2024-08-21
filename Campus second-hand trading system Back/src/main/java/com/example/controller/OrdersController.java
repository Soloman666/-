package com.example.controller;

import com.example.pojo.Orders;
import com.example.pojo.Result;
import com.example.pojo.Users;
import com.example.service.OrdersService;
import com.example.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class OrdersController {
    @Autowired
    private OrdersService ordersService2;


    @GetMapping("/allorders")
    public Result alllist(){
        log.info("查询订单信息");
        List<Orders> ordersList= ordersService2.alllist();
        return Result.success(ordersList);

    }

    @DeleteMapping("/orders/{ordernum}")
    public Result delete(@PathVariable Integer ordernum){
        log.info("根据订单号号删除：{}",ordernum);
        ordersService2.delete(ordernum);
        return Result.success();
    }

}
