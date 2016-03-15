package com.javarush.test.level18.lesson10.home08;

import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/
import java.util.*;

import java.io.*;
public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list= new ArrayList<String>();
        String s = null;
        while(true){
            s= r.readLine();
            if(!s.equalsIgnoreCase("exit")){
                list.add(s);
            }
            else break;
        }
        r.close();
        try{
            for(String str :list){
                ReadThread read = new ReadThread(str);
                read.start();
                read.join();
            }
        }
        catch(InterruptedException e){

        }
    }

    public static class ReadThread extends Thread {
        ArrayList<Integer> list = new ArrayList<Integer>();
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;  //implement constructor body
        }
        public void run() {
            try{
                FileInputStream in = new FileInputStream(fileName);
                while(in.available()>0){

                    int data = in.read();
                    list.add(data);
                }
                in.close();
                searchByte(list,fileName);
                System.out.println(resultMap);
            }
            catch(FileNotFoundException e){

            }
            catch(IOException e){

            }
        }
        public static void searchByte(ArrayList<Integer> list, String fileName){
            int max=0;
            int bytes = 0 ;
            int count = 0;
            for(int i=0; i<list.size();i++){
                count = Collections.frequency(list,list.get(i));
                if(count>max){
                    max=count;
                    bytes = list.get(i);
                }
            }
            resultMap.put(fileName, bytes);

        }



    }// implement file reading here - реализуйте чтение из файла тут
    }

