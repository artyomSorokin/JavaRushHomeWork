package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
r.close();

            long id = SetID(fileName)+1;
            StringBuilder b  = new StringBuilder(getID(id));
            b.append(" ").append(getproductName("Шорты пляжные синие")).append(getPrice("173.00")).append(getQuantity("12")+ "\r\n");
            String line = String.valueOf(b);
            FileWriter writer = new FileWriter(fileName,true);
            writer.write(line);
            writer.close();
        }

    public static String getproductName(String productName){
        String s;
        if(productName.length()>30){
            s = String.format("%.30s", productName);
        }
        else s= String.format("%-30s", productName);
        return s;
    }
    public static String getPrice(String price){
        String s;
        if(price.length()>8){
            s = String.format("%.8s", price);
        }
        else s= String.format("%-8s", price);
        return s;
    }
    public static String getQuantity(String quantity){
        String s;
        if(quantity.length()>4){
            s = String.format("%.4s", quantity);
        }
        else s= String.format("%-4s", quantity);
        return s;
    }
    public static String getID(long id){
        String s;
        String s1 = String.valueOf(id);
        if(s1.length()>8){
            s = String.format("%.8s", s1);
        }
        else s= String.format("%-8s", s1);
        return s;
    }
    public static long SetID(String fileName) throws IOException{
        ArrayList<Long> list = new ArrayList<Long>();
        long r;
        BufferedReader reader=new BufferedReader(new FileReader(fileName));
        if (!reader.ready()==true) r=1;
        else{while(reader.ready()){
            String i = reader.readLine();
            String s = i.substring(0,8);
            String[] h = s.split(" ");
            long f = Long.parseLong(h[0]);
            list.add(f);
        }
            reader.close();
            Collections.sort(list);
            r = list.get(list.size()-1);
        }
        return r;
    }
}
