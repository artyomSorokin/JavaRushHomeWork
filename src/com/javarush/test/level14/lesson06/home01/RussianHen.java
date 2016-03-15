package com.javarush.test.level14.lesson06.home01;


public class RussianHen extends Hen
{

    public int getCountOfEggsPerMonth()
    {
        return 17;
    }
    public String getDescription() {
        return super.getDescription() + " ћо€ страна - "+ Country.RUSSIA+". я несу "+getCountOfEggsPerMonth() +" €иц в мес€ц.";
    }
}
