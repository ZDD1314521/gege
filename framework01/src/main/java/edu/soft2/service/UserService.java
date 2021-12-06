package edu.soft2.service;

import edu.soft2.pojo.User;

public interface UserService {
    public int addUser(User user);
    public int delUser(User user);
    public int updUser(User user);
    public int seeUser(User user);
}
