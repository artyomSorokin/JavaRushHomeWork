package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

import java.util.*;
import java.text.*;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        String date = new String("JULY 2 2015");
        Date current = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH).parse(date);
        System.out.print(current + " = ");
        System.out.println(isDateOdd(date));
    }

    public static boolean isDateOdd(String date)
    {
        SimpleDateFormat format = new SimpleDateFormat("MMMM dd yyyy");

        Date date1 = new Date(115,0,1);

        Date date2 = new Date(date);
        long k = date2.getTime();
        long ms = 24*60*60*1000;
        int days = (int) (k/ms);


        if(days%2!=0)
            return true;
        else return false;
    }
}
