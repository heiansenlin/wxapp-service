package com.how2java.springboot.login.service;

import com.how2java.springboot.login.entity.Login;

public interface LoginService {
    Login getByOpenId(String openId);

    int save(Login login);
}
