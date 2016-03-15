package com.javarush.test.level14.lesson06.home01;


public class BelarusianHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 100;
    }
    public String getDescription() {
        return super.getDescription() + " ћо€ страна - "+ Country.BELARUS+". я несу "+getCountOfEggsPerMonth() +" €иц в мес€ц.";
    }
}
