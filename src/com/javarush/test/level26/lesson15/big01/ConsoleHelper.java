package com.javarush.test.level26.lesson15.big01;


import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper
{
    static BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String str="";
        try
        {
            str = reader.readLine();
            if("EXIT".equalsIgnoreCase(str))
            {
                throw new InterruptOperationException();
            }
        }
        catch (IOException e)
        {

        }
        return str;
    }


    public static String askCurrencyCode()throws InterruptOperationException{
        String code;
        while(true)
        {
            writeMessage("������� ��� ������");
            code = readString();
            if (code.length() == 3)
            {
                break;
            } else
            {
                writeMessage("������������ ������ ������,��������� ����");
            }
        }
            code = code.toUpperCase();
            return code;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage("������� ��� ����� ������������� �����. ������ - �������, ������ - ���������� �������: ");
        String line = readString();
        String [] currency = line.split(" ");
        try
        {
            if(currency.length==2 && Integer.parseInt(currency[0])>=0 && Integer.parseInt(currency[1])>=0)
            {
                return currency;
            }
            else{
                writeMessage("������������ ������ ������,��������� ����");
                getValidTwoDigits(currencyCode);
            }
        }
        catch(Exception e){
            writeMessage("������������ ������ ������,��������� ����");
            getValidTwoDigits(currencyCode);
        }
        return currency;

    }

    public static Operation askOperation() throws InterruptOperationException{
        System.out.println("�������� ��������: 1-���������� � �����, 2-������� �� �����, 3-������ ��������, 4-�����");
        Operation op=Operation.INFO;
        try{
            String enter=readString();
            int choise=Integer.parseInt(enter);
            op=Operation.getAllowableOperationByOrdinal(choise);
        }
        catch(Exception e){
            System.out.println("������������ ������ ������,��������� ����");
            askOperation();
        }
        return op;
    }

}
