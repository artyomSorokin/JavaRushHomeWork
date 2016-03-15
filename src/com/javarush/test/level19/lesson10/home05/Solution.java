package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        FileReader reader =new FileReader(args[0]);
        FileWriter writer = new FileWriter(args[1]);
        ArrayList<String> list= new ArrayList<String>();
        String text = "";
        while(reader.ready()){
            text = text+(char) reader.read();
        }

        String [] line = text.split(" ");

        for(String s: line){

            char [] c = s.toCharArray();

            for(int i=0; i<c.length;i++){
                if(Character.isDigit(c[i])){
                    if(list.contains(s)){

                    }
                    else list.add(s);
                }
            }

        }
        for(String s:list){
            writer.write(s+" ");
        }
        reader.close();
        writer.close();
    }
}
