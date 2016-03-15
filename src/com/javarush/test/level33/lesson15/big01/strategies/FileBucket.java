package com.javarush.test.level33.lesson15.big01.strategies;


import com.javarush.test.level33.lesson15.big01.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket
{
    Path path;
    File newFile;

    public FileBucket()
    {
        try
        {
            path = Files.createTempFile("tmp", null);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }

        newFile = path.toFile();
        newFile.deleteOnExit();
    }

    public long getFileSize()
    {
        return newFile.length();
    }

    public void putEntry(Entry entry)
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(entry);
            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry()
    {
        Entry entry = null;
        if (newFile.length() > 0)
        {
            try
            {
                FileInputStream fileInputStream = new FileInputStream(newFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                entry = (Entry) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }

            catch (Exception e)
            {
                ExceptionHandler.log(e);
            }
        }
        return entry;
    }

    public void remove()
    {
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
            ExceptionHandler.log(e);
        }
    }
}
