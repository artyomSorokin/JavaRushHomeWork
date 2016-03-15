package com.javarush.test.level33.lesson15.big01.tests;


import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.HashBiMapStorageStrategy;
import com.javarush.test.level33.lesson15.big01.strategies.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest
{
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids)
    {
        ids = new HashSet<>();
        Date dateStart = new Date();
        for(String line : strings){
            ids.add(shortener.getId(line));
        }
        Date dateFinish = new Date();
        long timeWork = dateFinish.getTime() - dateStart.getTime();
        return timeWork;
    }


    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings)
    {
        strings = new HashSet<>();
        Date dateStart = new Date();
        for(Long id : ids){
            strings.add(shortener.getString(id));
        }
        Date dateFinish = new Date();
        long timeWork = dateFinish.getTime() - dateStart.getTime();
        return timeWork;
    }

    @Test
    public void testHashMapStorage()
    {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener hashMap = new Shortener(hashMapStorageStrategy);
        Shortener hashBiMap = new Shortener(hashBiMapStorageStrategy);

        Set<Long> ids = new HashSet<>();

        Set<String> origStrings = new HashSet<>();
        for(long i=0;i<1000;i++)
        {
            origStrings.add(Helper.generateRandomString());
        }

        long hashMapWorkTimeId = getTimeForGettingIds(hashMap, origStrings, ids);
        long hashBiMapWorkTimeId = getTimeForGettingIds(hashBiMap, origStrings, ids);

        Assert.assertTrue(hashMapWorkTimeId > hashBiMapWorkTimeId);

        long hashMapWorkTimeStr = getTimeForGettingStrings(hashMap, ids, origStrings);
        long hashBiMapWorkTimeStr = getTimeForGettingStrings(hashBiMap, ids, origStrings);

        Assert.assertEquals(hashMapWorkTimeStr,hashBiMapWorkTimeStr, 5);
    }
}
