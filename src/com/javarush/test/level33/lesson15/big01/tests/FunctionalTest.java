package com.javarush.test.level33.lesson15.big01.tests;


import com.javarush.test.level33.lesson15.big01.Helper;
import com.javarush.test.level33.lesson15.big01.Shortener;
import com.javarush.test.level33.lesson15.big01.strategies.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest
{
    public void testStorage(Shortener shortener){
        String str1 = Helper.generateRandomString();
        String str2 = Helper.generateRandomString();
        String str3 = str1;
        Long id1 = shortener.getId(str1);
        Long id2 = shortener.getId(str2);
        Long id3 = shortener.getId(str3);
        Assert.assertNotEquals(id1, id2);
        Assert.assertNotEquals(id2, id3);
        Assert.assertEquals(id1, id3);
        String str4 = shortener.getString(id1);
        String str5 = shortener.getString(id2);
        String str6 = shortener.getString(id3);
        Assert.assertEquals(str1,str4);
        Assert.assertEquals(str2,str5);
        Assert.assertEquals(str3,str6);
    }


    @Test
    public void testHashMapStorageStrategy()
    {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        testStorage(new Shortener(hashMapStorageStrategy));
    }

    @Test
    public void testOurHashMapStorageStrategy()
    {
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        testStorage(new Shortener(ourHashMapStorageStrategy));
    }

    @Test
    public void testFileStorageStrategy()
    {
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        testStorage(new Shortener(fileStorageStrategy));
    }

    @Test
    public void testHashBiMapStorageStrategy()
    {
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        testStorage(new Shortener(hashBiMapStorageStrategy));
    }

    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        testStorage(new Shortener(dualHashBidiMapStorageStrategy));
    }

    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        testStorage(new Shortener(ourHashBiMapStorageStrategy));
    }
}
