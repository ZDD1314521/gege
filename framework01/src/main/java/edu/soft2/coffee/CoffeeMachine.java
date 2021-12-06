package edu.soft2.coffee;

import lombok.Data;

@Data
public class CoffeeMachine {
    private String color;
    private CoffeeBean coffeeBean;
    public void make(){
        System.out.println("我用"+getColor()+"色咖啡机，制作一杯"+getCoffeeBean().getFlavor()+"口味的咖啡");
    }
}
