package com.javarush.test.level14.lesson06.home01;


public class UkrainianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 25;
    }
    public String getDescription() {
        return super.getDescription() + " ћо€ страна - "+ Country.UKRAINE+". я несу "+getCountOfEggsPerMonth() +" €иц в мес€ц.";
    }
}
