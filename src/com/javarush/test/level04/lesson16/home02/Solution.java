package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/
import java.io.*;
public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                int n=Integer.parseInt(r.readLine());
                int m=Integer.parseInt(r.readLine());
                int k=Integer.parseInt(r.readLine());
        if(k>m&&k<n) System.out.println(k);
        else if(k>n&&k<m) System.out.println(k);
        if(m>k&&m<n) System.out.println(m);
        else if(m>n&&m<k) System.out.println(m);
        if(n>m&&n<k) System.out.println(n);
        else if(n>k&&n<m) System.out.println(n); //Напишите тут ваш код
    }
}
