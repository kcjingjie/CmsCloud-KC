package com.kc.es.dto;

import lombok.Data;

@Data
public class User {

    private String username;

    private String sex;

    private Integer age;

    public  User(String username,String sex,Integer age){
        this.username = username;
        this.sex = sex;
        this.age = age;
    }


}
