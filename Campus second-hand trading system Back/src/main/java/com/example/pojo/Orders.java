package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Integer ordernum ;
    private String selleraccount;
    private Integer number;
    private String goodname;
    private LocalDateTime date;
    private String account;
}
