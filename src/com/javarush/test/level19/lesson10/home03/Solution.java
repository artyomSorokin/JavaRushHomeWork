package com.javarush.test.level19.lesson10.home03;


import java.io.*;
import java.util.*;
/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        Scanner scanner= new Scanner(new FileReader(args[0]));
        int sizeLine=0;

        while(scanner.hasNextLine()){
            String [] line = scanner.nextLine().split(" ");
            sizeLine=line.length;
            Calendar calendar = new GregorianCalendar(Integer.parseInt(line[sizeLine-1]),Integer.parseInt(line[sizeLine-2])-1,Integer.parseInt(line[sizeLine-3]));
            Date bd = calendar.getTime();
            String name=getName(line, sizeLine-3);
            PEOPLE.add(new Person(name,bd));
        }
        scanner.close();
    }
    public static String getName(String [] line, int size){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<size;i++){
            sb.append(line[i]).append(" ");
        }
        return line.toString();
    }

}
