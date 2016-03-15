package com.javarush.test.level04.lesson10.task04;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в одной строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String s = "S";
        int n = 1;

        while (n <= 10)
        {
            int m = 1;
            while (m <= 10)
            {
                System.out.print(s);
                m++;
            }
            System.out.println();
            n++;   //Напишите тут ваш код

        }
    }
}
