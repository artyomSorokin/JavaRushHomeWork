package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
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

            if (nAge1 > nAge2) System.out.println(nAge2);
            else if (nAge1 == nAge2) System.out.println(nAge2);
            else System.out.println(nAge1);   //Напишите тут ваш код

        /* данные для тестирования:
        введите 1 и 2, минимум =  1
        введите 2 и 1, минимум =  1
        введите 1 и 1, минимум =  1
        введите -1 и -2, минимум =  -2
         */

    }
}