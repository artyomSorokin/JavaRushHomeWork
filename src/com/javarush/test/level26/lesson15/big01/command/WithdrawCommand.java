package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level17.lesson10.home08.NotEnoughMoneyException;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.*;

class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage("������� ��� ������");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cur  = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        while(true)
        {
            ConsoleHelper.writeMessage("������� �����");
            String sumEnter = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(sumEnter);
            }
            catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("������������ ������, ��������� �������");
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage("������������ ������, ��������� �������");
                continue;
            }
            if (!cur.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage("�� ���������� ����� �� �����");
                continue;
            }
            try
            {
                cur.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("��� ����� ��� ������ ������ �����");
                continue;
            }
            ConsoleHelper.writeMessage(String.format("%d %s was withdrawn successfully", sum, currencyCode));
            break;
        }
    }
}
