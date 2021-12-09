package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.springframework.stereotype.Controller;
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
        return user;

    }
}
