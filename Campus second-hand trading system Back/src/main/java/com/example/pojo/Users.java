package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

    public class Users {
        private Integer id;
        private String account;
        private String password;
        private String grade;
        private Double balance;
    }

