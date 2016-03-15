package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("Are you sure you to exit? <y/n>");
        String answer = ConsoleHelper.readString();
        if ("Y".equalsIgnoreCase(answer.trim()))
            ConsoleHelper.writeMessage("See you later");
    }
}
