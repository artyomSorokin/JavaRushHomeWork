package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/
import java.io.*;
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception{
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(bytearray);
        System.setOut(stream);
        testString.printSomething();
        String result = bytearray.toString();
        System.setOut(consoleStream);
        String s=result.replaceAll("te", "??");
        System.out.println(s);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}
