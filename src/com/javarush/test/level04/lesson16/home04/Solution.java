package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/
import java.io.*;
public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name=r.readLine();
        int age1=Integer.parseInt(r.readLine());

        int age2=Integer.parseInt(r.readLine());

        int age3=Integer.parseInt(r.readLine());
        System.out.println("Меня зовут "+name);
        System.out.println("Я родился "+age3+"."+age2+"."+age1);  //Напишите тут ваш код
    }
}
