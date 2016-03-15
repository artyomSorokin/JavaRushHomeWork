package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        int countsp=0;
        int countliters=0;
        double result=0;
        if(args.length>0){
            FileInputStream in = new FileInputStream(args[0]);
            while(in.available()>0){
                countliters++;
                int data = in.read();
                if(data == Integer.valueOf(' ')){
                    countsp++;
                }


            }

            in.close();
        }

        if( countliters== 0){

        } else {
            result = (double)countsp / countliters * 100;
        }
        System.out.println(result);
    }
}
