package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level17.lesson10.home08.NotEnoughMoneyException;

import java.util.*;
public class CurrencyManipulator
{
    private String currencyCode;
    Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations=new HashMap<Integer, Integer>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
            denominations.put(denomination,denominations.get(denomination)+count);
        }
        else
        {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        int sum=0;
        for(Map.Entry<Integer,Integer> pair: denominations.entrySet()){
            int den=pair.getKey();
            int count=pair.getValue();
            int countSum=den*count;
            sum=sum+countSum;
        }
        return sum;
    }
    public boolean hasMoney(){
        if(denominations.isEmpty()) return false;
        else return true;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return expectedAmount <= getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount)throws NotEnoughMoneyException
    {
        TreeMap<Integer, Integer> Map = new TreeMap<Integer, Integer>();
        Map.putAll(denominations);
        NavigableMap<Integer, Integer> navigableMap = Map.descendingMap();
        if (expectedAmount <= 0) throw new NotEnoughMoneyException();
        int tempAmount = expectedAmount;

        while (true)
        {

            TreeMap<Integer, Integer> tempMap = new TreeMap<Integer, Integer>();
            Iterator<Map.Entry<Integer, Integer>> iter = navigableMap.entrySet().iterator();
            //поиск решения
            while (iter.hasNext())
            {
                Map.Entry<Integer, Integer> TempPair = iter.next();
                int key = TempPair.getKey();
                int value = TempPair.getValue();
                while (key <= tempAmount)
                {
                    if(tempMap.containsKey(key))
                        value = tempMap.get(key);
                    if (value > 0)
                    {
                        tempAmount -= key;
                        value--;
                        tempMap.remove(key);
                        tempMap.put(key, value);
                    } else
                    {
                        break;
                    }

                }
            }

            //решение не найдено - удаляем самый большой номинал
            if(tempAmount!=0)
            {
                tempAmount=expectedAmount;
                Iterator<Map.Entry<Integer, Integer>> iterator = navigableMap.entrySet().iterator();
                Map.Entry<Integer, Integer> pair = (NavigableMap.Entry) iterator.next();
                navigableMap.remove(pair.getKey());
            }
            //решение найдено
            if (tempAmount == 0)
            {
                for (Map.Entry<Integer, Integer> Entry : tempMap.entrySet())
                {
                    int key=Entry.getKey();
                    int value=Entry.getValue();
                    denominations.remove(key);
                    if(value>0)
                    {
                        denominations.put(key, value);
                        int temp=navigableMap.get(key);
                        navigableMap.remove(key);
                        navigableMap.put(key, temp-value);
                    }
                }

                break;
            }

            if (navigableMap.isEmpty()) throw new NotEnoughMoneyException();
        }

        return navigableMap;
    }

}
