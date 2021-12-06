package edu.soft2.controller;

import edu.soft2.pojo.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
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
    public String upload(MultipartFile image,HttpServletRequest request) throws IOException {
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
        System.out.println("上传"+"文件到"+realPath+"完毕，共计"+size+"字节，上传后文件名为"+newname+".");
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
        return uuid+"."+extension;
    }
}



