package com.example.service.impl;

import com.example.mapper.AdminMapper;
import com.example.mapper.GoodsMapper;
import com.example.pojo.Admin;
import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicesImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(Admin admin) {
        return adminMapper.getByAdminAndPassword(admin);
    }
}
