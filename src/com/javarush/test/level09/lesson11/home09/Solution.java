package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Cat cat1 = new Cat("kot1");
        Cat cat2 = new Cat("kot2");
        Cat cat3 = new Cat("kot3");
        Cat cat4 = new Cat("kot4");
        Cat cat5 = new Cat("kot5");
        Cat cat6 = new Cat("kot6");
        Cat cat7 = new Cat("kot7");
        Cat cat8 = new Cat("kot8");
        Cat cat9 = new Cat("kot9");
        Cat cat10 = new Cat("kot10");

        HashMap<String,Cat> map = new HashMap<>();
        map.put("Barsik", cat1);
        map.put("Bublik", cat2);
        map.put("Bars", cat3);
        map.put("Bereza", cat4);
        map.put("Bar", cat5);
        map.put("Barbos", cat6);
        map.put("Baris", cat7);
        map.put("Barlon", cat8);
        map.put("Baron", cat9);
        map.put("Barpot", cat10);
        return map;//напишите тут ваш код
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> set = new HashSet<Cat>();
        Iterator <Map.Entry<String, Cat>> iter = map.entrySet().iterator();
        while(iter.hasNext())
        {
            set.add(iter.next().getValue());//напишите тут ваш код
        }
        return set; //напишите тут ваш код
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
