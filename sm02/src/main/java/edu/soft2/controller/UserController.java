package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "user")
public class UserController {
    //删除操作
    @RequestMapping(value = "/gotoLogin")
    public String gotoLogin(){
        System.out.println("---------gotoLogin()------");
        return "forward:/index.jsp";
    }
    //删除操作
    @RequestMapping(value = "delete")
    public String delete(){
        System.out.println("---------delete()------");
        return "hello";
    }
    //登录
    @RequestMapping(value = "login")
    public String login(User user, HttpSession session) {
        System.out.println("---------login(登录)------");
        //调用业务成
        int flag=1;
        if (flag == 1) {
            session.setAttribute("user", user);
            return "welcome";
        }
       return "hello";
    }

    @RequestMapping("/logout")//被拦截器拦截的方法
    public String logout(HttpServletRequest request){
        System.out.println("--------logout()------");
        HttpSession session= request.getSession();
        session.invalidate();//session里的数据被清空
        System.out.println("session失效");
        String msg="你已退出登录！";
        request.setAttribute("msg",msg);
        return "forward:/index.jsp";
    }
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("------------用户管理---------");
        return "hello";
    }
    @RequestMapping(value = "upload",method = {RequestMethod.POST})
    public String upload(MultipartFile image, HttpServletRequest request, HttpServletResponse response, Map<String,Object> map) throws IOException {
        System.out.println("------upload（）------");
        //获取文件输出流对象
        InputStream is= image.getInputStream();
        //获取文件名称
        String filename=image.getOriginalFilename();
        //设置上传路线
        String realPath=request.getServletContext().getRealPath("/images");
        System.out.println("上传路径="+realPath);
        //设置上传server后的新名称
        String newname= doFilename(filename);
        OutputStream os=new FileOutputStream(new File(realPath,filename));//
        int size= IOUtils.copy(is,os);//完成文件拷贝的大小（字节）
        if (size > 0) {
            map.put("res","ok");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.println("<script language=/");


            System.out.println("上传"+"文件到"+realPath+"完毕，共计"+size+"字节，上传后文件名为"+newname+".");

        }
        //资源
        os.close();is.close();
        return "welcome";//提示框
    }

    @RequestMapping(value = "upload2",method = {RequestMethod.POST})
    public String upload2(MultipartFile[] image,HttpServletRequest request) throws IOException {
        System.out.println("------upload2（）------");
        InputStream is=null;
        OutputStream os=null;
        for (MultipartFile imageFile:image) { //多个文件上传
            System.out.println("-----upload2（）.foreach");
            //获取文件输出流对象
            is= imageFile.getInputStream();
            //获取文件名称
            String filename=imageFile.getOriginalFilename();
            if (filename.equals("")) {
                System.out.println("空字符串，进入下一轮循环");
                continue;//结束本轮循环，进入下一轮循环
            }
            //设置上传路线
            String realPath=request.getServletContext().getRealPath("/images");
            System.out.println("上传路径="+realPath);
            //设置上传server后的新名称
            String newname= doFilename(filename);
            os=new FileOutputStream(new File(realPath,filename));//
            int size= IOUtils.copy(is,os);//完成文件拷贝的大小（字节）
            System.out.println("上传"+"文件到"+realPath+"完毕，共计"+size+"字节，上传后文件名为"+newname+".");

        }
        //资源释放（原则：先开后关，后开先关)
        os.close();is.close();
        return  "welcome";//提示框
    }

    private String doFilename(String filename){
        //
        String extension= FilenameUtils.getExtension(filename);
        String uuid=UUID.randomUUID().toString();
        return uuid+"."+extension;//上传文件的新名字
    }
    @RequestMapping(value = "/download/{filename}")
    public void download(@PathVariable String filename,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String realPath=request.getServletContext().getRealPath("/images");//从哪里下载的
        System.out.println("下载路径realPath="+realPath);
        InputStream is=new FileInputStream(new File(realPath,filename));
        OutputStream os= response.getOutputStream();
        IOUtils.copy(is,os);//拷贝
        os.close();is.close();//关闭io流
    }

    //针对中文名称，需要分浏览器来处理
    public String doFileName2(HttpServletRequest request, String filename){
        try{
            //获取请求头部信息的User-Agent对应的值
            String userAgent=request.getHeader("User-Agent");
            if(userAgent.toUpperCase().indexOf("FIREFOX")>0){//火狐浏览器
                filename= "=?UTF-8?B?"+(new String(Base64.encodeBase64(filename.getBytes("utf-8"))))+"?=";
            }else{//其他浏览器
                filename  = URLEncoder.encode(filename,"utf-8");
            }
            System.out.println("下载文件名="+filename);
        }catch(Exception e){
            e.printStackTrace();
        }
        return filename;
    }
}



