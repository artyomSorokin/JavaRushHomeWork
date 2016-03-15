package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader = new BufferedReader(new FileReader(r.readLine()));
        String teg = args[0];
        String tegOpen = "<".concat(teg);
        String tegClose = "</"+teg+">";
        StringBuilder sb = new StringBuilder();
        while(reader.ready()){
            sb=sb.append(reader.readLine());
        }
        r.close();
        reader.close();
        String s =sb.toString().replace("/r/n","");
        System.out.println(s);
        int sizeTegOpen=tegOpen.length();
        int sizeTegClose = tegClose.length();


        searchTeg(s,tegOpen,tegClose,sizeTegOpen,sizeTegClose);


    }
    public static void searchTeg(String s, String tegOpen,String tegClose,int sizeTegOpen,int sizeTegClose){

        if(s.contains(tegOpen)){


            int index = s.indexOf(tegOpen);
            int lastIndex = s.lastIndexOf(tegClose);
            String s1 = s.substring(index, lastIndex+sizeTegClose);
            System.out.println(s1);
            int index1 = s1.indexOf(tegOpen);
            int lastIndex1 = s1.lastIndexOf(tegClose);
            String s2 = s1.substring(index1+sizeTegOpen,lastIndex1);
            searchTeg(s2,tegOpen,tegClose,sizeTegOpen,sizeTegClose);

        }
    }

}
