package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/
import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String name = r.readLine();
        r.close();
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(name));
        while(reader.ready()){
            int i = Integer.parseInt(reader.readLine());
            if (i%2==0)list.add(i);

        }
        reader.close();
        Collections.sort(list);

        for(Integer i:list){
            System.out.println(i);
        }
    } // напишите тут ваш код
    }

