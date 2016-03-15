package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by alla on 20.09.2015.
 */
public class Singleton
{
    private static Singleton instance = null;

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
