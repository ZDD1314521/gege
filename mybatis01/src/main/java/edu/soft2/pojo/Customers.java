package edu.soft2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customers {
    private int uid;
    private String username;
    private String upwd;
    private String qq;
    private String nickname;
    private String birthday;
    private String createtime;
    private String headpic;

}
