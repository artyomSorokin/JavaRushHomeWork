package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/
import java.io.*;
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArray);
        System.setOut(stream);
        testString.printSomething();

        System.setOut(consoleStream);
        String[] result = byteArray.toString().split("\\n");
        String pitch = "JavaRush - курсы Java онлайн";

        for(int i=0;i<result.length;i++){

            System.out.println(result[i]);
            if(i%2 !=0) System.out.println(pitch);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
