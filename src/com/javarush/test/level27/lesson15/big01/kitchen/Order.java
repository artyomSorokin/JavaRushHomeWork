package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order
{
    Tablet tablet;
    List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet=tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty(){
        if(dishes.isEmpty()) return true;
        else return false;
    }

    public int getTotalCookingTime(){
        int sum=0;
        for(Dish d : dishes){
            int time = d.getDuration();
            sum =sum+time;
        }
        return sum;
    }

    public String toString(){
        return dishes.isEmpty() ? "" : String.format("Your order: %s %s", dishes.toString(),tablet.toString());
    }
}
