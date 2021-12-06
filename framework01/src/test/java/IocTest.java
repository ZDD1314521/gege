import edu.soft2.print.Printer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {
    ApplicationContext context =
            new ClassPathXmlApplicationContext("applicationContext.xml");
//    @Test
//    public void testCoffee(){
//
//        CoffeeMachine machine= (CoffeeMachine) context.getBean("coffeeMachine");//注入
//        machine.make();
//    }

    @Test
    public void testPrinter(){
        Printer printer = (Printer) context.getBean("printer");
        printer.print();
    }
}
