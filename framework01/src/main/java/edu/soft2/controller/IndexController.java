package edu.soft2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
    //1.接受处理数据
    //2.调用业务逻辑（n/a）
    //3.页面跳转
    @RequestMapping(value="/sayHello")//方法的url访问地址
    public String sayHello(){
        System.out.println("hello,springmvc?!");
        //erl：/WEB-INF/pages/success.jsp
        return "success";//页面跳转（与视图解析器的前后缀拼接出url）
    }
    @RequestMapping("/sayHi")
    public String sayHi(){
        System.out.println("------sayHi()---------");
        return "Hi";
    }
}
