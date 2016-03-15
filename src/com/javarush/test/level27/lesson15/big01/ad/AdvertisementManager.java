package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdvertisementManager
{
    private int timeSeconds;
    private final AdvertisementStorage storage = AdvertisementStorage.getInstance();

    public AdvertisementManager(int timeSeconds)
    {
        this.timeSeconds = timeSeconds;
    }

    public void processVideos()throws NoVideoAvailableException{
        List<Advertisement> allAd = storage.list();
        if(storage.list().isEmpty()){
            throw new NoVideoAvailableException();
        }
        Collections.sort(allAd, new Comparator<Advertisement>()
        {

            @Override
            public int compare(Advertisement o1, Advertisement o2)
            {
                if(o1.getAmountPerOneDisplaying() != o2.getAmountPerOneDisplaying()){
                    return Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
                }
                else{
                    long l1 = o1.getAmountPerOneDisplaying()/o1.getDuration()*1000;
                    long l2 = o2.getAmountPerOneDisplaying()/o2.getDuration()*1000;
                    return Long.compare(l1,l2);
                }
            }
        });



        int timeQuit = timeSeconds;
        for(Advertisement ad : allAd){
            if(timeQuit>=ad.getDuration()){
                ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d",
                        ad.getName(), ad.getAmountPerOneDisplaying(), ad.getAmountPerOneDisplaying()/ad.getDuration()*1000));
                timeQuit = timeQuit - ad.getDuration();
                ad.revalidate();
            }
            if(timeQuit<=0) break;
        }

        if (timeQuit == timeSeconds) throw new NoVideoAvailableException();


    }
}
