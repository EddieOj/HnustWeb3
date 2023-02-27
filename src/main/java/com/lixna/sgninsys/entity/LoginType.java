package com.lixna.sgninsys.entity;

public enum LoginType {
    USER("User"), ADMIN("Admin");

    private String type;    //定义的是登陆的类型

    private LoginType(String type){
        this.type=type;
    }

    @Override
    public String toString() {
        return this.type.toString();
    }
}

