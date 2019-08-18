package com.how2java.springboot.login.controller;

import com.how2java.springboot.login.entity.Login;
import com.how2java.springboot.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("login")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("Init")
    public String Init(@RequestParam("code") String code) {
        String str = "";
        HashMap<String, String> map = new HashMap<>();
        try {
            //调用微信接口
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxac052b4ee9437925&secret=b8f11a9555d5c6564d78bf1da7e5360c&js_code=" + code + "&grant_type=authorization_code";
            //获得返回字符串
            str = sendGet(url, "", null);
            //解析返回字符串
            str = str.substring(1, str.length() - 2);
            String[] split = str.split("\",");
            for (String s:split){
                s = s.substring(1);
                String[] split1 = s.split("\":\"");
                map.put(split1[0],split1[1]);
            }
            System.out.println(map);
            //根据返回的openId获取数据库中是否存在
            Login openId = loginService.getByOpenId(map.get("openid"));
            //如果不存在则新建保存用户
            if (openId==null){
                Login login = new Login();
                login.setUuid(UUID.randomUUID().toString());
                login.setOpenId(map.get("openid"));
                login.setSessionKey(map.get("session_key"));
                loginService.save(login);
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("login")
    public ModelAndView login(String name, String password) {

        return null;
    }

    public static String sendGet(String url, String param, Map<String, String> header) throws UnsupportedEncodingException, IOException {
        String result = "";
        BufferedReader in = null;
        String urlNameString = url;
        URL realUrl = new URL(urlNameString);
        // 打开和URL之间的连接
        URLConnection connection = realUrl.openConnection();
        //设置超时时间
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(15000);
        // 设置通用的请求属性
        if (header != null) {
        }
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 建立实际的连接
        connection.connect();
        // 获取所有响应头字段
        Map<String, List<String>> map = connection.getHeaderFields();
        // 遍历所有的响应头字段
//        for (String key : map.keySet()) {
//            System.out.println(key + "--->" + map.get(key));
//        }
        // 定义 BufferedReader输入流来读取URL的响应，设置utf8防止中文乱码
        in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
        String line;
        while ((line = in.readLine()) != null) {
            result += line;
        }
        if (in != null) {
            in.close();
        }
        return result;
    }
}
