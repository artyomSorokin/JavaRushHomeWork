package com.javarush.test.level17.lesson10.bonus02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/
import java.util.*;
import java.text.*;

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        int n= args.length;
        if(n<2) return;
        SimpleDateFormat  date1 = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        SimpleDateFormat date2 = new SimpleDateFormat ("dd-MMM-y", Locale.ENGLISH);
        if(args[0].equals("-c")){
            for(int i = 1; i<n ; i+=3){
                String name = args[i];
                try{
                    Date bd = date1.parse(args[i+2]);
                    if(args[i+1].equals("м")){
                        allPeople.add(Person.createMale(name, bd));
                        System.out.println(allPeople.size() - 1);
                    }
                    else if (args[i + 1].equals("ж")) {
                        allPeople.add(Person.createFemale(name, bd));
                        System.out.println(allPeople.size() - 1);
                    }
                }
                catch(ParseException e){
                    e.printStackTrace();
                }
            }
        }
        else if(args[0].equals("-u")){
            for(int i=1;i<n;i+=4){
                try{
                    int id = Integer.parseInt(args[i]);
                    if(id>allPeople.size()-1){
                        break;
                    }
                    String name = args[i+1];
                    Date bd = date1.parse(args[i+3]);
                    if(args[i+2].equals("м")){
                        Person person = Person.createMale(name, bd);
                        allPeople.set(id,person);
                    }
                    else if(args[i+2].equals("ж")){
                        Person person = Person.createFemale(name, bd);
                        allPeople.set(id,person);
                    }

                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if(args[0].equals("-d")){
            for(int i=1; i <n;i++){
                try{
                    int id = Integer.parseInt(args[i]);
                    if(id>allPeople.size()-1) break;
                    allPeople.get(id).setBirthDay(null);
                    allPeople.get(id).setName(null);
                    allPeople.get(id).setSex(null);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if(args[0].equals("-i")){
            for( int i=1;i<n;i++){
                try{
                    int id = Integer.parseInt(args[i]);
                    if(id>allPeople.size()-1) break;
                    Person p = allPeople.get(id);
                    String sex;
                    if(p.getSex() == Sex.FEMALE){
                        sex="ж";
                    }
                    else sex = "м";
                    System.out.println(p.getName() + " " + sex +" "+ date2.format(p.getBirthDay()));
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
        //start here - начни тут
    }
}
