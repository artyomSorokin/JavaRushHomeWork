package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> list = new TreeSet<String>();
        while(true){
            String filename = r.readLine();
            if(!filename.equals("end")) list.add(filename);
            else break;
        }
        String s = list.first();
        String name = s.substring(0,s.length()-6);
        FileOutputStream out = new FileOutputStream(name,true);
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()){
            String str = iter.next();
            FileInputStream in = new FileInputStream(str);
            while(in.available()>0){
                int data = in.read();
                out.write(data);
            }
            in.close();
        }
        r.close();
        out.close();
    }
}
