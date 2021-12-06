import edu.soft2.pojo.User;
import edu.soft2.service.UserService;
import edu.soft2.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AopTest {
    int expected;//
    String name;//
    String pwd;//
    public AopTest(int expected,String name,String pwd){}
    @Parameterized.Parameters
            public  static Collection<Object[]>t(){//
        return Arrays.asList(new Object[][]{
                {1,"peter","123"},{1,"john","456"},{1,"zhang","789"}
        });
         }


    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//@Test
//    public void helloworldTest(){
//        HelloworldService helloworldService=
//                (HelloworldService) context.getBean("helloworldService");
//        helloworldService.sayHello();
//        helloworldService.sayHai();
//    }

        @Test
        public void userServiceTest() {
            UserService service = (UserService) context.getBean(UserServiceImpl.class);
               String name=("peter");
               String pwd=("123");
               String email=("peter@xxx.com");
//            User user = new User();
//            user.setName("peter");
//            user.setPwd("123");
//            user.setEmail("peter@xxx.com");
            User user = (User) context.getBean(User.class);
            user.setName(name);user.setPwd(pwd);user.setEmail(email);
            if (service.addUser(user) == 1) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
            if (service.updUser(user) == 1) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
            if (service.delUser(user) == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
            if (service.seeUser(user) == 1) {
                System.out.println("查询成功");
            } else {
                System.out.println("查询失败");
            }
        }
    }

