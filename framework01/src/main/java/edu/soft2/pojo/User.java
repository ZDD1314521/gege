package edu.soft2.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component//装配bean到IoC
public class User {
    //@Value("peter")
    private String name;
    //@Value("123")
    private String pwd;
    //@Value("peter@abc.com")
    private  String email;
}
