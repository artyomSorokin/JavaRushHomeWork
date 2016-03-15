package com.javarush.test.level14.lesson06.home01;


public class MoldovanHen extends Hen
{
    public int getCountOfEggsPerMonth()
    {
        return 14;
    }
    public String getDescription() {
        return super.getDescription() + " ћо€ страна - "+ Country.MOLDOVA+". я несу "+getCountOfEggsPerMonth() +" €иц в мес€ц.";
    }
}
