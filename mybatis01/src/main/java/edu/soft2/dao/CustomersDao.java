package edu.soft2.dao;

import edu.soft2.pojo.Customers;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//接口实现类
public interface CustomersDao {
    public Customers findCustById(int id);//名称，参数，返回值

    public List<Customers> findAllCusts();//

    public Customers findCustByIdAndPwd(@Param(value = "id") String uid, @Param(value = "pwd") String pwd);//登陆查询

    public void addCust(@Param(value = "name") String username,@Param("pwd") String upwd);

    public void delCust(@Param("id") int uid);//删除

    public void updateCust(
            @Param("id")int uid,@Param("name")String username,@Param("phone") String qq,@Param("add")String nickname);

    public List<Customers> findCusts(
            @Param("name") String username,@Param("phone") String qq,@Param("add")String nickname
    );
}
