package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.IOException;
import java.util.Locale;

public class CashMachine
{
    public static void main(String[] args) throws IOException
    {
        Locale.setDefault(Locale.ENGLISH);

        try
        {
            Operation op;
            do
            {
                op = ConsoleHelper.askOperation();
                CommandExecutor.execute(op);
            }
            while (op != Operation.EXIT);
        }
        catch(InterruptOperationException e){
            try {
                CommandExecutor.execute(Operation.EXIT);
            } catch (InterruptOperationException ignored) {
            }
            ConsoleHelper.writeMessage("До новых встреч!");
        }
        }


    }

