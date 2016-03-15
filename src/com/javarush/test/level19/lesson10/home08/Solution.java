package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/
import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader r =new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileReader(r.readLine()));
        r.close();

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            StringBuilder sb = new StringBuilder(line);
            System.out.println(sb.reverse());
        }
        scanner.close();
    }
}
