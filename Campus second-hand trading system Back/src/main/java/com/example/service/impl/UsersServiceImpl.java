package com.example.service.impl;

import com.example.mapper.UsersMapper;
import com.example.pojo.Goods;
import com.example.pojo.Users;
import com.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;



    @Override
    public Users login(Users users) {
        return usersMapper.getByaccountAndPassword(users);
    }

    @Override
    public List<Users> list() {

        return usersMapper.list();
    }

    @Override
    public void delete(Integer id) {
        usersMapper.deleteById(id);
    }

    @Override
    public void save(Users users) {
        usersMapper.insert(users);
    }

    @Override
    public Users getById(Integer id) {
        return usersMapper.getById(id);
    }

    @Override
    public void update(Users users) {
        usersMapper.update(users);


    }

    @Override
    public List<Goods> myList(String account) {
        return usersMapper.myList(account);
    }

    @Override
    public void register(Users users) {
        usersMapper.register(users);
    }

    @Override
    public List<Goods> undeliveredList(String account) {
        return usersMapper.undeliveredList(account);
    }
}
