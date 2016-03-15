package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        String input = reader.readLine();
        String str1 = input.substring(input.indexOf("?") + 1);
        String[] str2 = str1.split("&");
        for (String str3 : str2)
        {
            if (str3.contains("="))
            {
                String[] str4 = str3.split("=");
                String str5 = str4[0];
                list1.add(str5);
                if (str5.equals("obj"))
                {
                    list2.add(str4[1]);
                }
            } else list1.add(str3);
        }
        for (String s : list1)
        {
            System.out.print(s + " ");
        }
        System.out.println("");
        for (String s : list2)
        {
            try
            {
                alert(Double.parseDouble(s));
            }
            catch (Exception e)
            {
                alert(s);
            }    //add your code here
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
