package edu.soft2.service.impl;

import edu.soft2.service.IHelloworldService;

//@Component
public class HelloworldService implements IHelloworldService {
    @Override
    public void sayHello() {
        System.out.println("你好！Hello");
    }
    public void sayHai() {
        System.out.println("嗨！Hi");
    }
}
