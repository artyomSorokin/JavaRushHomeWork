package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = r.readLine();
        String fileName2 = r.readLine();
        FileInputStream in1 = new FileInputStream(fileName1);
        FileInputStream in2 = new FileInputStream(fileName2);
        byte [] buffer1 = new byte[in1.available()];
        byte [] buffer2 = new byte[in2.available()];
        while(in1.available()>0){
            in1.read(buffer1);
        }
        while(in2.available()>0){
            in2.read(buffer2);
        }
        FileOutputStream out = new FileOutputStream(fileName1);
        byte [] buffer3 = new byte[buffer1.length+buffer2.length];
        System.arraycopy(buffer2, 0, buffer3, 0, buffer2.length);
        System.arraycopy(buffer1,0, buffer3,buffer2.length, buffer1.length);
        out.write(buffer3);
        in1.close();
        r.close();
        in2.close();
        out.close();
    }
}
