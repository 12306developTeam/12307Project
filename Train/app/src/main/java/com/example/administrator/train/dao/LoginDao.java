package com.example.administrator.train.dao;

import com.example.administrator.train.model.User;

/**
 * Created by Administrator on 2017/5/8.
 */
public interface LoginDao {

    public boolean checkLogin(User user);
}
