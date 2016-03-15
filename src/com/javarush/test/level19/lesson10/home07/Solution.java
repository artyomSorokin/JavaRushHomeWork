package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(new FileReader("d:/frt.txt"));
        List<String> list = new ArrayList<String>() ;

        FileWriter writer = new FileWriter("d:/frt2.txt");
        while(scanner.hasNext()){
            String word = scanner.next();
            if(word.length()>6){
                list.add(word);
            }
        }
        scanner.close();
        for(int i=0;i<list.size();i++){
            if(i==list.size()-1){
                writer.write(list.get(i));
            }
            else writer.write(list.get(i)+ ",");
        }
        writer.close();
    }
}
