package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/
import java.io.*;
public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream out;
    AdapterFileOutputStream(FileOutputStream out){
        this.out = out;
    }
    public void flush() throws IOException{
        out.flush();
    }

    public void writeString(String s) throws IOException{
        byte [] b = s.getBytes();
        out.write(b);
    }

    public void close() throws IOException{
        out.close();
    }
}

