import edu.soft2.dao.CustomersDao;
import edu.soft2.pojo.Customers;
import edu.soft2.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class CustomersTest {
    @Test
    public void testRetrive(){//查
       // SqlSession sqlSession= SqlSessionUtil.openSqlSession();
        CustomersDao customersDao=(CustomersDao) SqlSessionUtil.getMapper(CustomersDao.class);
        // Customers cust=customersDao.findCustById(1);
        List<Customers> cust=customersDao.findCusts("zdd","","");
        System.out.println(cust);
    }
    @Test
    public void testCUD(){//增删改，提交事务
        CustomersDao customersDao=(CustomersDao) SqlSessionUtil.getMapper(CustomersDao.class);
        customersDao.updateCust(16,"ge","","");
        SqlSessionUtil.commit();

    }
}
