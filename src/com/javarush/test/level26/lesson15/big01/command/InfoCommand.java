package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;


class InfoCommand implements Command
{
    @Override
    public void execute()
    {
        boolean money =false;
        for(CurrencyManipulator cur : CurrencyManipulatorFactory.getAllCurrencyManipulators()){

            if(cur.hasMoney() && cur.getTotalAmount()>0){
                ConsoleHelper.writeMessage(cur.getCurrencyCode() + " - " + cur.getTotalAmount());
                money=true;
            }

        }
        if(!money) ConsoleHelper.writeMessage("No money available.");
    }
}
