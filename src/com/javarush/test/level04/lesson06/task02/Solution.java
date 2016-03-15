package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sAge1 = reader.readLine();
        int nAge1 = Integer.parseInt(sAge1);
              String sAge2 = reader.readLine();
        int nAge2 = Integer.parseInt(sAge2);
              String sAge3 = reader.readLine();
        int nAge3 = Integer.parseInt(sAge3);
              String sAge4 = reader.readLine();
        int nAge4 = Integer.parseInt(sAge4);
        int max;
        int [] mas = new int [4];
        mas[0]=nAge1;
        mas[1]=nAge2;
        mas[2]=nAge3;
        mas[3]=nAge4;
        max=mas[0];
        for (int i=0;i<mas.length; i++){
            if(max<mas[i]) max=mas[i];
        }
        System.out.println(max);  //Напишите тут ваш код

    }
}
