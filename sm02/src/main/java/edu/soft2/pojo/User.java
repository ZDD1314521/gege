package edu.soft2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.Address;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String username;
    String pwd;
    int age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date birthday;
    Address address;
}