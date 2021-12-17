package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("json")
public class JsonController {
    @RequestMapping(value = "getUser")
    @ResponseBody   //将java对象转化为json格式数据
    public User getUser(){
        User user=new User();
        user.setUsername("peter");
        user.setBirthday(new Date());
        System.out.println("user="+user);
        return user;
    }
    @RequestMapping(value = "getRegJsonInfo")
    public void getRegJsonInfo(@RequestBody User user){
        //@RequestBody告诉控制器，发来的请求的json格式，可以封装为User类型
        System.out.println("接收到的注册信息="+user);

    }
}
