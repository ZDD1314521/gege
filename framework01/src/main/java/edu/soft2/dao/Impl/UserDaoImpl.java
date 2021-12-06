package edu.soft2.dao.Impl;

import edu.soft2.dao.UserDao;
import edu.soft2.pojo.User;
import org.springframework.stereotype.Repository;

@Repository//从IoC容器中注入装配bean
public class UserDaoImpl implements UserDao {
    private User user;
//    @Autowired//从IoC注入
//    @Qualifier("user") //匹配Bean的id
    @Override
    public int addUser(User user) {
//        if (user !=null){
//            return 1;
//        }
//        return 0;
        if (user !=null) {
            //1.获取JDBC的链接对象Connection
            //2.sql语句拼接
            String sql =
             "insert user(name,pwd,email) values("+user.getName()+","+user.getPwd()+","+user.getEmail()+")";
            System.out.println("add的sql语句："+sql);
            //3，PreparedStstement执行sql语句，用executeUpdate()
            //4.获取sql执行结果
            System.out.println("数据库add操作完毕");
            return 1;
        }
        return 0;
    }

    @Override
    public int delUser(User user) {
        if (user !=null) {
            //1.获取JDBC的链接对象Connection
            //2.sql语句拼接
            String sql =
                    "insert user(name,pwd,email) values("+user.getName()+","+user.getPwd()+","+user.getEmail()+")";
            System.out.println("add的sql语句："+sql);
            //3，PreparedStstement执行sql语句，用executeUpdate()
            //4.获取sql执行结果
            System.out.println("数据库AOP操作");
            return 1;
        }
        return 0;
    }

    @Override
    public int updUser(User user) {
        if (user !=null) {
            //1.获取JDBC的链接对象Connection
            //2.sql语句拼接
            String sql =
                    "insert user(name,pwd,email) values("+user.getName()+","+user.getPwd()+","+user.getEmail()+")";
            System.out.println("add的sql语句："+sql);
            //3，PreparedStstement执行sql语句，用executeUpdate()
            //4.获取sql执行结果
            System.out.println("数据库AOP操作");
            return 1;
        }
        return 0;
    }

    @Override
    public int seeUser(User user) {
        if (user !=null) {
            //1.获取JDBC的链接对象Connection
            //2.sql语句拼接
            String sql =
                    "insert user(name,pwd,email) values("+user.getName()+","+user.getPwd()+","+user.getEmail()+")";
            System.out.println("add的sql语句："+sql);
            //3，PreparedStstement执行sql语句，用executeUpdate()
            //4.获取sql执行结果
            System.out.println("数据库AOP操作");
            return 1;
        }
        return 0;
    }
}
