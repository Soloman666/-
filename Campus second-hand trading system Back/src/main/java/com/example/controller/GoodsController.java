package com.example.controller;

import com.example.pojo.Goods;
import com.example.pojo.Result;
import com.example.pojo.Users;
import com.example.service.GoodsService;
import com.example.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController


@CrossOrigin
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goods")
    public Result list(){
        log.info("查询商品信息");

        List<Goods> goodsList= goodsService.list();
        return Result.success(goodsList);

    }

    @DeleteMapping("/goods/{number}")
    public Result delete(@PathVariable Integer number){
        log.info("根据商品号删除：{}",number);
        goodsService.delete(number);
        return Result.success();
    }

    @PostMapping("/addgoods")
    public Result save(@RequestBody Goods goods){
        log.info("新增商品：{}",goods);
        goodsService.save(goods);
        return Result.success();
    }
    @GetMapping("/searchgoods/{number}")
    public Result getById(@PathVariable Integer number){
        log.info("根据商品号查询商品信息，number：{}",number);

        Goods goods = goodsService.getByNumber(number);
        return Result.success(goods);
    }

    @GetMapping("/searchgoodsname/{goodname}")
    public Result getByName(@PathVariable String goodname){
        log.info("根据商品名称查询商品信息，name：{}",goodname);

        List<Goods> thegoods = goodsService.getByName(goodname);
        return Result.success(thegoods);
    }

}
