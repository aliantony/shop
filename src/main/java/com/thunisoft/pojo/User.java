package com.thunisoft.pojo;

import java.io.Serializable;

/**
 * Created by yhan219 on 2017/1/6.
 */
public class User implements Serializable {

    private String id;

    private String username;

    private String password;

    private String tel;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
