package edu.soft2.util;

import edu.soft2.dao.CustomersDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    //针对当前线程的Thread实例的get/set进行存/取sqlSession对象的操作
    private static ThreadLocal<SqlSession> tl=new ThreadLocal<SqlSession>();
    static{
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml"); //1.读取配置文件
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);//2.创建SqlSessionFactory
        } catch (IOException e) {
            e.printStackTrace();
            new RuntimeException("读取主配置时失败");
        }

    }
    public static SqlSession openSqlSession(){
        SqlSession sqlSession=tl.get();
        if (sqlSession == null) {
            sqlSession=sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

    public static void closeSqlSession(){
        SqlSession sqlSession= openSqlSession();
        sqlSession.close();
        tl.remove();
    }
    public static void commit(){//事务提交
        SqlSession sqlSession= openSqlSession();
        sqlSession.commit();
        tl.remove();
    }
    public static void rollback(){//事务回滚
        SqlSession sqlSession= openSqlSession();
        sqlSession.rollback();
        tl.remove();
    }


    public static Object getMapper(Class clazz){
        SqlSession sqlSession=openSqlSession();
        return sqlSession.getMapper(clazz);
    }

}

