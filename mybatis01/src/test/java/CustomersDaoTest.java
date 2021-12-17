import edu.soft2.dao.CustomersDao;
import edu.soft2.pojo.Customers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CustomersDaoTest {
    @Test
    public void testQuery() throws IOException {
        //1.读取配置文件
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建SqlSessionFactory
         SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        //3.创建SqlSession
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //4.通过SqlSession
        CustomersDao customersDao=sqlSession.getMapper(CustomersDao.class);
        //5.调用接口实现类的方法
        Customers customers = customersDao.findCustById(1);
        //6.打印查询结果
        System.out.println(customers);

    }
//查单个操作
    @Test
    public void testQueryAll() throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= factory.openSession();
        CustomersDao customersDao=sqlSession.getMapper(CustomersDao.class);  //
        List<Customers> lists=  customersDao.findAllCusts();
        for (Customers cust:lists){
            System.out.println("用户名"+cust.getUsername()+"，密码："+cust.getNickname());
        }
    }
//查一个人的所有信息
    @Test
    public void testLogon() throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= factory.openSession();
        CustomersDao customersDao=sqlSession.getMapper(CustomersDao.class);  //
        Customers cust=customersDao.findCustByIdAndPwd("peter","123");
            System.out.println("用户名"+cust);

    }
//增操作
    @Test
    public void testCreate() throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= factory.openSession();
        CustomersDao customersDao = sqlSession.getMapper(CustomersDao.class);
        customersDao.addCust("peter4","456");
        sqlSession.commit();//提交事务

    }


//删除操作
    @Test
    public void testDelete() throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= factory.openSession();

        CustomersDao customersDao=sqlSession.getMapper(CustomersDao.class);  //
        customersDao.delCust(1);
        sqlSession.commit();//提交事务

    }

    @Test
    public void testUpdate() throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= factory.openSession();

        CustomersDao customersDao=sqlSession.getMapper(CustomersDao.class);
        customersDao.delCust(2);
        sqlSession.commit();//提交事务

    }
}
