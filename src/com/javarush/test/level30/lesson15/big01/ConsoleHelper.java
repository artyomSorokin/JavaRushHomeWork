package com.javarush.test.level30.lesson15.big01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }
    public static String readString()   {
        String result;
        while (true)
        {
            try
            {
                result = reader.readLine();
                break;
            }
            catch (IOException e)
            {
                writeMessage("��������� ������ ��� ������� ����� ������. ���������� ��� ���.");
            }
        }
        return result;
    }

    public static int readInt() {
        int result ;
        while (true)
        {
            try
            {
                result = Integer.parseInt(readString());
                break;
            }
            catch (NumberFormatException e)
            {
                writeMessage("��������� ������ ��� ������� ����� �����. ���������� ��� ���.");

            }
        }
        return result;
    }
}
