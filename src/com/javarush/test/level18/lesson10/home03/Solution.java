package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1= reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();
        reader.close();

        FileInputStream in2 = new FileInputStream(filename2);
        FileOutputStream outfilename1 = new FileOutputStream(filename1,true);
        while(in2.available()>0){
            byte [] buffer = new byte[in2.available()];
            int count=in2.read(buffer);
            outfilename1.write(buffer,0,count);
        }
        in2.close();
        FileInputStream in3 = new FileInputStream(filename3);
        while(in3.available()>0){
            byte [] buffer = new byte[in3.available()];
            int count = in3.read(buffer);
            outfilename1.write(buffer, 0,count);
        }
        in3.close();
        outfilename1.close();
    }
}
