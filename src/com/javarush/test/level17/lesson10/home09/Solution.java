package com.javarush.test.level17.lesson10.home09;

import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/
import java.util.*;
import java.io.*;
public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException{

        BufferedReader r =  new BufferedReader(new InputStreamReader(System.in));
        String name1 = r.readLine();
        String name2 = r.readLine();
        r.close();
        BufferedReader file1 =  new BufferedReader(new FileReader(name1));
        BufferedReader file2 =  new BufferedReader(new FileReader(name2));
        while(file1.ready()){
            String s = file1.readLine();
            allLines.add(s);
        }
        file1.close();
        while(file2.ready()){
            String s= file2.readLine();
            forRemoveLines.add(s);
        }
        file2.close();


        try{
            new Solution().joinData();

        }
        catch(CorruptedDataException e){

        }

    }

    public void joinData () throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
            return;
        }
        else{
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
