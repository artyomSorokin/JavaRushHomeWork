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
            writeMessage("Введите код валюты");
            code = readString();
            if (code.length() == 3)
            {
                break;
            } else
            {
                writeMessage("Неправильный формат данных,повторите ввод");
            }
        }
            code = code.toUpperCase();
            return code;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        writeMessage("Введите два целых положительных числа. Первое - номинал, второе - количество банкнот: ");
        String line = readString();
        String [] currency = line.split(" ");
        try
        {
            if(currency.length==2 && Integer.parseInt(currency[0])>=0 && Integer.parseInt(currency[1])>=0)
            {
                return currency;
            }
            else{
                writeMessage("Неправильный формат данных,повторите ввод");
                getValidTwoDigits(currencyCode);
            }
        }
        catch(Exception e){
            writeMessage("Неправильный формат данных,повторите ввод");
            getValidTwoDigits(currencyCode);
        }
        return currency;

    }

    public static Operation askOperation() throws InterruptOperationException{
        System.out.println("Выберите операцию: 1-Информация о счете, 2-остаток на счету, 3-снятие наличных, 4-выход");
        Operation op=Operation.INFO;
        try{
            String enter=readString();
            int choise=Integer.parseInt(enter);
            op=Operation.getAllowableOperationByOrdinal(choise);
        }
        catch(Exception e){
            System.out.println("Неправильный формат данных,повторите ввод");
            askOperation();
        }
        return op;
    }

}
