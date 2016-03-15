package com.javarush.test.level15.lesson12.home01;


import java.io.*;
import java.util.*;
import java.io.IOException;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();

        while(true){
            String volue = r.readLine();
            if(!volue.equals("exit")) list.add(volue);
            else break;
        }
        r.close();
        for(String s:list ){
            if(s.contains(".")) print(Double.parseDouble(s));
            else{
                try{
                    int n = Integer.parseInt(s);
                    if(n>0&&n<128) print((short)n);
                    else print(n);
                }
                catch(Exception e){
                    print(s);
                }
            }
        }      //напиште тут ваш код
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
