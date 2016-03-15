package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/
import java.io.*;
public class Solution {
    private static byte key = 5;
    public static void main(String[] args) throws IOException{

        if(args.length<3) return;

        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);
        while(in.available()>0){
            byte[] buffer = new byte[in.available()];
            in.read(buffer);

            out.write(encode(buffer));
        }
        in.close();
        out.close();
    }
    public static byte[] encode(byte[] data){
        byte [] res = new byte[data.length];
        for(int i=0; i<data.length;i++){
            res[i] = (byte)(data[i]^key);
        }
        return res;
    }

}
