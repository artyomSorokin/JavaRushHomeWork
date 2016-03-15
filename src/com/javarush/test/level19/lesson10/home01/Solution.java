package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        HashMap<String,Double> map = new HashMap<String,Double>();

        Scanner scanner = new Scanner( new FileReader(args[0]));

        while(scanner.hasNextLine()){
            String [] text=scanner.nextLine().split(" ");
            if(map.containsKey(text[0])){
                map.put(text[0], map.get(text[0])+Double.parseDouble(text[1]));
            }
            else map.put(text[0], Double.parseDouble(text[1]));
        }
        scanner.close();
        Map<String,Double> sortedMap = new TreeMap<String,Double>(new Comparator<String>(){
            public int compare(String lhs,String rhs){
                return lhs.compareTo(rhs);
            }
        });
        sortedMap.putAll(map);
        for(Map.Entry<String, Double> entry : sortedMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
