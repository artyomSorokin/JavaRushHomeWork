package com.javarush.test.level04.lesson06.task06;

/* И 18-ти достаточно
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись «И 18-ти достаточно».
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
                String s = reader.readLine();
                String n = reader.readLine();
        int n1 = Integer.parseInt(n);
        if(n1>20)
            System.out.println("И 18-ти достаточно");   //Напишите тут ваш код

    }
}
