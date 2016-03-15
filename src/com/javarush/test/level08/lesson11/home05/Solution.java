package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char [] arraychar = s.toCharArray();//напишите тут ваш код
        arraychar[0] = Character.toUpperCase(arraychar[0]);
        for(int i=0; i<arraychar.length;i++){
            if(arraychar[i]== ' ') arraychar[i+1]=Character.toUpperCase(arraychar[i+1]);
        }
        System.out.println(arraychar); //напишите тут ваш код
    }


}
