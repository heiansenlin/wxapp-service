package com.how2java.springboot.login.service.serviceImpl;

import com.how2java.springboot.login.entity.Login;
import com.how2java.springboot.login.mapper.LoginMapper;
import com.how2java.springboot.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Login getByOpenId(String openId) {
        return loginMapper.getByOpenId(openId);
    }

    @Override
    public int save(Login login) {
        return loginMapper.save(login);
    }
}
