package com.javarush.test.level27.lesson15.big01.kitchen;


import java.util.Observable;
import java.util.Observer;

public class Waitor implements Observer
{

    public void update(Observable observable, Object order){
        System.out.println(order.toString()+ " was cooked by " + observable.toString());
    }
}
