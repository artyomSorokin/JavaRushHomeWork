package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        HashMap <String, Double> map = new HashMap<String, Double>();
        ArrayList<Double> list = new ArrayList<Double>();
        Scanner scanner = new Scanner(new FileReader(args[0]));
        while(scanner.hasNextLine()){
            String [] text = scanner.nextLine().split(" ");
            if(map.containsKey(text[0])){
                map.put(text[0],map.get(text[0])+Double.parseDouble(text[1]));
            }
            else{
                map.put(text[0],Double.parseDouble(text[1]));
            }
        }
        scanner.close();
        for(Map.Entry<String, Double> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list);
        double maxSalary = list.get(list.size()-1);
        for(Map.Entry<String,Double> entry: map.entrySet()){
            if(entry.getValue().equals(maxSalary)){
                System.out.println(entry.getKey());
            }
        }
    }
}
