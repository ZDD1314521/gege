package edu.soft2.interceptor;

import edu.soft2.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("------------CheckUserInterceptor.preHandle----------");
        Object opj= request.getSession().getAttribute("user");
        if ((opj == null) && (opj instanceof User)) {
            System.out.println("已通过连接器，放行-------");
            return true;//通过拦截器

        }
        System.out.println("因登陆异常,而被拦截（/t重定向首页index。jsp）----");
//        request.getRequestDispatcher("hello").forward(request,response);
        response.sendRedirect(request.getContextPath()+"/index.jsp");//重定向到首页
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("CheckUserInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
