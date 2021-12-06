package edu.soft2.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class Printer {

    private  Ink ink;
    private Paper paper;
    @Autowired
    @Qualifier("a5Paper")
    public void setInk(Paper paper) {
        this.paper = paper;
    }
    @Resource(name = "colorInk")
//    @Autowired
//    @Qualifier("colorInk")
    public void setInk(Ink ink) {
        this.ink= ink;
    }

    public Ink getInk() {
        return ink;
    }

    public Paper getPaper() {
        return paper;
    }

    public void print() {
        System.out.println("用"+ink.getType()+"墨盒打印一张"+paper.getSize()+"纸上面！");
    }
}

