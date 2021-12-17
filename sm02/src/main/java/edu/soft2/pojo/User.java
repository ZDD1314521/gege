package edu.soft2.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.sun.xml.ws.wsdl.writer.document.http.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    String username;
    String pwd;
    int age;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy/MM/dd")
    Date birthday;//springmvc进行类型转换
    Address address;//自定义对象类型
}
