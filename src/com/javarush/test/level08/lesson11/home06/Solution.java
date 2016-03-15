package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> kids = new ArrayList<Human>();

        ArrayList<Human> parents1 = new ArrayList<Human>();
        ArrayList<Human> parents2 = new ArrayList<Human>();
        Human child1 = new Human("child1", true, 5 ,  new ArrayList<Human>());
        Human child2 = new Human("child2", true, 10 , new ArrayList<Human>());
        Human child3 = new Human("child3", true, 15 ,  new ArrayList<Human>());

        kids.add(child1);
        kids.add(child2);
        kids.add(child3);


        parents1.add(new Human("father", true, 52, kids));
        parents2.add(new Human("Mother", false, 51, kids));

        Human granfather1 = new Human("crandfather1", true, 84, parents1);
        Human granfather2 = new Human("crandfather2", true, 82, parents2);
        Human grandmother1 =new Human("crandmother1", true, 79, parents1);
        Human grandmother2 =new Human("crandmother2", true, 79, parents2);

        System.out.println(granfather1);
        System.out.println(granfather2);
        System.out.println(grandmother1);
        System.out.println(grandmother2);
        for(Object o: parents1){
            System.out.println(o);
        }
        for(Object s: parents2){
            System.out.println(s);
        }

        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);//напишите тут ваш код
    }

    public static class Human
    {

        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;//напишите тут ваш код

        public  Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name=name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        } //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
