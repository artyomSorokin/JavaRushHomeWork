package com.javarush.test.level27.lesson15.big01;



import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable
{
    private static Logger log = Logger.getLogger(Tablet.class.getName());

    final int number;

    public Tablet(int number)
    {
        this.number = number;
    }

    public void createOrder(){
        try {
            final Order order = new Order(this);
            if (order.isEmpty()) return;

            ConsoleHelper.writeMessage(order.toString());

            setChanged();
            notifyObservers(order);
                try
                {
                    AdvertisementManager advert = new AdvertisementManager(order.getTotalCookingTime() * 60);
                    advert.processVideos();
                }
                catch (NoVideoAvailableException e)
                {
                    log.log(Level.INFO, "No video is available for the order " + order);
                }
            }



        catch(IOException e){
            log.log(Level.SEVERE, "Console is unavailable.");
        }

    }

    public String toString(){
        return "of Tablet{number="+number+"}";
    }
}
