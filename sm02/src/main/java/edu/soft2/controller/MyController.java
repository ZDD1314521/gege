package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {
    @RequestMapping(value = "/hello",method = {RequestMethod.GET})
    public String hello(HttpServletRequest request){//这个方法对应的url路径：
        System.out.println("------hello-------");
        //接收数据
        String name= request.getParameter("name");//通过参数url，获取参数值
        System.out.println("name="+name);//将数据放入request
        //调用业务，跳转页面
        return "/common/head.jsp";//拼接URL；/WEB-INF/pages/hello.jsp
    }
    @RequestMapping(value = "/param1",method = {RequestMethod.GET,RequestMethod.GET})
    public String param1(HttpServletRequest request){//这个方法对应的url路径：http//

        // localhost:8080/[项目名]/hello.do
        System.out.println("--------param1------");
        String username=request.getParameter("username");//通过参数url，获取参数值
        String age=request.getParameter("age");//通过参数url，获取参数值
        System.out.println("username="+username+",age="+age);
        request.setAttribute("username",username);//将数据放入request
        request.setAttribute("age",age);//将数据放入request
        //调用业务，跳转页面
        return "hello";//拼接url：/WEB-INF/pages/hello.jsp
    //默认重定向
    }

    //测试
    @RequestMapping("testMeV")//测试转发跳转
    public ModelAndView testMeV(){

        System.out.println("MoController.testMaV");
        User user=new User();user.setUsername("peter");//User对象实例创建
        ModelAndView MaV=new ModelAndView();//ModelAndView对象实例创建
        MaV.addObject("user",user);//像默认作用域request中添加User对象
        MaV.setViewName("hello");//相当于跳转的url（前缀+hello+后缀）
        return MaV;
    }

    @RequestMapping("testForward")//测试转发跳转
    public String testForward(){
        System.out.println("---------testForward（）-------");
//        return "hello";//转发到/WEB-INF/pages/下的hello.jsp
        return "forward:/reg.jsp";//转发到wedapp下的reg.jsp
    }
    @RequestMapping("testRedirect")
    public String testRedirect(){//测试重定向跳转
        System.out.println("---------testRedirect-------");
        return "redirect:/reg.jsp";//重定向到wedapp下的reg.jsp
    }

    @RequestMapping(value = "/param2",method = {RequestMethod.GET,RequestMethod.GET})
    public String param2(HttpServletRequest request){//这个方法对应的url路径：http//
        // localhost:8080/[项目名]/hello.do
        System.out.println("--------param2------");
        String username=request.getParameter("username");//通过参数url，获取参数值
        String age=request.getParameter("age");//通过参数url，获取参数值
        System.out.println("username="+username+",age="+age);
        request.setAttribute("username",username);//将数据放入request
        request.setAttribute("age",age);//将数据放入request
        //调用业务，跳转页面
        //默认重定向forward（重定向，url变化）=redirect（转发，url不变）（url=地址栏）
//        return "forward:hello";//拼接url：/WEB-INF/pages/hello.jsp

        return "redirect:hello";//拼接url：/WEB-INF/pages/hello.jsp
    }


    @RequestMapping(value = "/param3",method = {RequestMethod.GET,RequestMethod.GET})
    public String param3(HttpServletRequest request, HttpSession session){//这个方法对应的url路径：http//
        // localhost:8080/[项目名]/hello.do
        System.out.println("--------param3------");
        String username=request.getParameter("username");//通过参数url，获取参数值
        String age=request.getParameter("age");//通过参数url，获取参数值
        System.out.println("username="+username+",age="+age);
//        request.setAttribute("username",username);//将数据放入request
//        request.setAttribute("age",age);//将数据放入request
        session.setAttribute("age",age);//将数据放入session
        session.setAttribute("username",username);//
        //调用业务，跳转页面
        //默认重定向forward（重定向，url变化）=redirect（转发，url不变）（url=地址栏）
//        return "forward:hello";//拼接url：/WEB-INF/pages/hello.jsp

        return "hello";//拼接url：/WEB-INF/pages/hello.jsp
    }




    @RequestMapping(value = "/param4",method = {RequestMethod.GET,RequestMethod.GET})
    public String param4(String username,int age){//这个方法对应的url路径：http//
        // localhost:8080/[项目名]/hello.do
        System.out.println("--------param4------");
//        String username=request.getParameter("username");//通过参数url，获取参数值
//        String age=request.getParameter("age");//通过参数url，获取参数值
//
////        request.setAttribute("username",username);//将数据放入request
////        request.setAttribute("age",age);//将数据放入request
//        session.setAttribute("age",age);//将数据放入session
//        session.setAttribute("username",username);//
        System.out.println("username="+username+",age="+age);
        //调用业务，跳转页面
        //默认重定向forward（重定向，url变化）=redirect（转发，url不变）（url=地址栏）
//        return "forward:hello";//拼接url：/WEB-INF/pages/hello.jsp

        return "hello";//拼接url：/WEB-INF/pages/hello.jsp
    }



    @RequestMapping(value = "test1")
    public String text1(){
        System.out.println("--------test1()-------");
        //调用业务，转跳页面
        return "forward:/param2/test3";//跳转到控制器test2.do
    }


    @RequestMapping(value = "test2")
    public String text2(){
        System.out.println("--------test2()-------");
        //调用业务，转跳页面
        return "hello";//跳转到视图：WEB-INF/pages、hello.jsp
    }



    @RequestMapping(value = "/param5",method = {RequestMethod.GET,RequestMethod.GET})
    public String param5(@RequestParam(value = "username",required = false) String u,@RequestParam(value = "age",required = true,defaultValue = "20") int a){//这个方法对应的url路径：http//
        // localhost:8080/[项目名]/hello.do
        System.out.println("--------param5()------");
        System.out.println("username="+u+",age="+a);
        return "hello";//拼接url：/WEB-INF/pages/hello.jsp
    }

    @RequestMapping(value = "/param6",method = {RequestMethod.GET,RequestMethod.GET})
    public String param6(HttpServletRequest request){//这个方法对应的url路径：http//
        // localhost:8080/[项目名]/hello.do
        System.out.println("--------param6------");
        System.out.println("username="+request.getParameter("username")+",age="+request.getParameter("age"));
        //调用业务，跳转页面
        return "hello";//拼接url：/WEB-INF/pages/hello.jsp
    }
}
