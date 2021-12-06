package edu.soft2.interceptor;

import edu.soft2.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
/*
*相当于aop前置增强方法
* */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //从session获取user对象
        Object obj = request.getSession().getAttribute("user");
        if (obj != null && obj instanceof User) {
            return true;//返回true，通过拦截器
        } else {
            //跳转至登陆页面
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return false;//返回true，被拦截器阻断
        }
    }
    /*
     *相当于aop后置增强方法
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
