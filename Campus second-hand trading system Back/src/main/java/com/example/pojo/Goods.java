package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
    private Integer number;
    private Integer sellerid;
    private String selleraccount;
    private String goodname;
    private Double prize;
    private String place;
    private String fineness;
    private String state;


}
