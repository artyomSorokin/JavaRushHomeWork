package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/
import java.io.*;
public class FileConsoleWriter extends FileWriter{
    private FileWriter fileWriter;

    FileConsoleWriter(String fileName)throws IOException{
        super(fileName);
    }
    FileConsoleWriter(String fileName,boolean append)throws IOException{
        super(fileName,append);
    }
    FileConsoleWriter(File file)throws IOException{
        super(file);
    }
    FileConsoleWriter(File file,boolean append)throws IOException{
        super(file,append);
    }
    FileConsoleWriter(FileDescriptor fd){
        super(fd);
    }

    public void write(char [] cbuf)throws IOException{
        super.write(cbuf);
        System.out.println(cbuf);
    }
    public void write(int c)throws IOException{
        super.write(c);
        System.out.println((char)c);
    }
    public void write(String str)throws IOException{
        super.write(str);
        System.out.println(str);
    }
    public void write(char [] cbuf , int off,int len)throws IOException{
        super.write(cbuf);
        System.out.println(String.copyValueOf(cbuf).substring(off,off+len));
    }
    public void write(String str, int off,int len)throws IOException{
        super.write(str);
        System.out.println(str.substring(off, off+len));
    }
}