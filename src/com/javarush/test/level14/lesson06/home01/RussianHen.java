package com.javarush.test.level14.lesson06.home01;


public class RussianHen extends Hen
{

    public int getCountOfEggsPerMonth()
    {
        return 17;
    }
    public String getDescription() {
        return super.getDescription() + " ��� ������ - "+ Country.RUSSIA+". � ���� "+getCountOfEggsPerMonth() +" ��� � �����.";
    }
}
