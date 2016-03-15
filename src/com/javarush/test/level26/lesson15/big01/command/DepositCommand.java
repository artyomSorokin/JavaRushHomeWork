package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level17.lesson10.home08.NotEnoughMoneyException;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.*;

class DepositCommand implements Command
{




        @Override
        public void execute() throws InterruptOperationException
        {
            String CurrencyCode=ConsoleHelper.askCurrencyCode();
            CurrencyManipulator manipulator= CurrencyManipulatorFactory.getManipulatorByCurrencyCode(CurrencyCode);
            int amount;

            while(true) {
                ConsoleHelper.writeMessage("Input amount");
                amount=Integer.parseInt(ConsoleHelper.readString());
                if(manipulator.isAmountAvailable(amount))break;
                else ConsoleHelper.writeMessage("Invalid amount");
            }
            try
            {
                Map<Integer, Integer> map=manipulator.withdrawAmount(amount);
                for (Map.Entry<Integer, Integer> pair :map.entrySet())
                    ConsoleHelper.writeMessage("\t"+pair.getKey()+" - "+pair.getValue());

                ConsoleHelper.writeMessage("Successful withdrawal");
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("Not enough money");
            }

        }

    }


