package com.cn.lx.excel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer userid;

    private String username;

    private String password;

    private String phone;

    public User(String username,String password, String phone){
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

}