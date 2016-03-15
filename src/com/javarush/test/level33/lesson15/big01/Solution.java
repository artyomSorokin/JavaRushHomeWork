package com.javarush.test.level33.lesson15.big01;


import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> ids = new HashSet<>();
        for(String line : strings){
            ids.add(shortener.getId(line));
        }
        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> lines = new HashSet<>();
        for(Long id : keys){
            lines.add(shortener.getString(id));
        }
        return lines;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> lines = new HashSet<>();
        for(long i=0;i<elementsNumber;i++)
        {
            lines.add(Helper.generateRandomString());
        }

        Shortener shortener = new Shortener(strategy);
        Set<Long> keys;
        Date startK = new Date();
        keys = getIds(shortener,lines);
        Date endK = new Date();
        long timeWorkKeys = endK.getTime() - startK.getTime();
        Helper.printMessage(String.valueOf(timeWorkKeys));

        Set<String> values;
        Date startV = new Date();
        values = getStrings(shortener,keys);
        Date endV = new Date();
        long timeWorkValues = endV.getTime() - startV.getTime();
        Helper.printMessage(String.valueOf(timeWorkValues));

        if(lines.equals(values))
        {
            Helper.printMessage("Тест пройден.");
        }
        else
        {
            Helper.printMessage("Тест не пройден.");
        }
    }

    public static void main(String[] args)
    {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        testStrategy(hashMapStorageStrategy,1000);
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        testStrategy(ourHashMapStorageStrategy,1000);
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        testStrategy(fileStorageStrategy,100);
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        testStrategy(ourHashBiMapStorageStrategy, 1000);
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        testStrategy(hashBiMapStorageStrategy,1000);
        DualHashBidiMapStorageStrategy dualHashBidiMap = new DualHashBidiMapStorageStrategy();
        testStrategy(dualHashBidiMap, 1000);
    }
}
