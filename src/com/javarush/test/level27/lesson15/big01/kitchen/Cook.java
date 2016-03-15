package com.javarush.test.level27.lesson15.big01.kitchen;






import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer
{
    String name;

    public Cook(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public void update(Observable observable, Object order){
        Order order1 = (Order) order;
        System.out.println("Start cooking - " + order1.toString() + ", cooking time " + order1.getTotalCookingTime() + "min");
        setChanged();
        notifyObservers(order);

    }
}
