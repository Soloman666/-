package com.example.controller;

import com.example.pojo.Goods;
import com.example.pojo.Orders;
import com.example.pojo.Result;
import com.example.pojo.Users;
import com.example.service.UsersService;
import com.example.service.GoodsService;
import com.example.service.OrdersService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
public class UsersController {
    public String myAccount;
    public String thisGood;
    public String seller;
    public double myvalue;
    public Integer myid;

    @Autowired
    private UsersService usersService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrdersService ordersService;

//    private  static Logger logger = (Logger) LoggerFactory.getLogger(UsersController.class);

//    @RequestMapping(value = "/users",method = RequestMethod.GET)
    @GetMapping("/users")
    public Result list(){
        log.info("查询用户信息");

      List<Users> usersList= usersService.list();
        return Result.success(usersList);


    }
    @DeleteMapping("/users/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据账号删除：{}",id);
        usersService.delete(id);
        return Result.success();
    }


    @PostMapping("/addusers")
    public Result save(@RequestBody Users users){
        log.info("新增用户：{}",users);
        usersService.save(users);
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody Users users){
        log.info("新增用户：{}",users);
        usersService.register(users);
        return Result.success();
    }


    @GetMapping("/addusers/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据id查询用户信息，id：{}",id);

       Users users = usersService.getById(id);
        return Result.success(users);
    }

    @PutMapping("/addusers")
    public Result update(@RequestBody Users users){
        log.info("更新用户信息：{}",users);
        usersService.update(users);
        return Result.success();
    }
    @PostMapping("/userlogin")
    public Result userLogin(@RequestBody Users users){
        myAccount = users.getAccount();


        log.info("用户登录: {}",users);
        Users us = usersService.login(users);
        if (us!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",us.getId());
            claims.put("account",us.getAccount());
           String jwt= JwtUtils.generateJwt(claims);
            myid = us.getId();
           return Result.success(jwt);
        }
        return Result.error("账号或密码错误！");
    }
    @GetMapping("/mygoods")
    public Result myList(){
        String account = myAccount;
        log.info("根据账号查询商品信息");
        account = myAccount;
        List<Goods> myGoodsList= usersService.myList(account);
        return Result.success(myGoodsList);

    }
    @GetMapping("/undeliveredgoods")
    public Result undeliveredList(){
        String account = myAccount;
        log.info("根据账号查询未交付的商品信息");
        account = myAccount;
        List<Goods> undeliveredGoodsList= usersService.undeliveredList(account);
        return Result.success(undeliveredGoodsList);

    }

    @PutMapping("/shopping1")
    public Result updatestate(@RequestBody Goods goods){
        thisGood = goods.getGoodname();
        seller = goods.getSelleraccount();
        myvalue = goods.getPrize();


        log.info("购买商品：{}",goods);
        goodsService.updatestate(goods);
        return Result.success();
    }

    @PutMapping("/shopping2/{number}")
    public Result updatestate2(@PathVariable Integer number){

        log.info("确认交付商品：{}",number);
        goodsService.updatestate2(number);
        return Result.success();
    }

    @PostMapping("/insertorder")
    public Result insert(){
        log.info("新增订单");
        String account = myAccount;
        String goodname = thisGood;
        String selleraccount = seller;
       LocalDateTime now = LocalDateTime.now();
        ordersService.insert(account,goodname,selleraccount,now);
        return Result.success();


    }

    @GetMapping("/orders")
    public Result mylist(String account){
        account = myAccount;
        log.info("根据买家查询订单信息，{}",account);

        List<Orders> ordersList= ordersService.mylist(account);
        return Result.success(ordersList);
    }

    @PostMapping("/addmygoods")
    public Result addMyGood(@RequestBody Goods goods){

         Integer id = myid;
        String myaccount = myAccount;
        log.info("用户新增了商品");
        goodsService.addMyGood(goods,id,myaccount);
        return Result.success();
    }
}
