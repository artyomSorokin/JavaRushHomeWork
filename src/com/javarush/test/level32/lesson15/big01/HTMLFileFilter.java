package com.javarush.test.level32.lesson15.big01;


import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter
{

    @Override
    public boolean accept(File file)
    {
        if(file.isDirectory()){
            return true;
        }
        else if (!file.isDirectory()){
            String fileName = file.getName().toLowerCase();
            if(fileName.endsWith(".html") || fileName.endsWith(".htm")){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
