package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
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
        Integer [] mas = new Integer[3];
        mas[0]=nAge1;
        mas[1]=nAge2;
        mas[2]=nAge3;

        Arrays.sort(mas,Collections.reverseOrder());
        for ( int i=0;i<mas.length;i++){
            System.out.print(mas[i]+" ");
        }    //Напишите тут ваш код

    }
}
