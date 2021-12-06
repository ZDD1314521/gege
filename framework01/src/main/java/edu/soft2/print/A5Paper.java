package edu.soft2.print;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//功能类
@Component
public class A5Paper extends Paper{
    @Override
    @Value("A5规格")
    public void setSize(String size) {
        super.setSize(size);
    }
}
