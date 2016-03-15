package com.javarush.test.level26.lesson15.big01;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulatorFactory
{

    private static Map<String, CurrencyManipulator> map = new HashMap<String,CurrencyManipulator>();
    private CurrencyManipulatorFactory()
    {

    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if(map.containsKey(currencyCode)){
            return map.get(currencyCode);
        }
        else{
            CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode,currencyManipulator);
            return currencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        return map.values();
    }
}
