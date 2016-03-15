package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.
2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution {
    private static List<File> fileList = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        File path = new File(args[0]);
        String resultFileAbsolutePath = args[1];

        scanDirectory(path);

        Collections.sort(fileList, new Comparator<File>()
        {
            @Override
            public int compare(File o1, File o2)
            {
                String fileName1 = o1.getName();
                String fileName2 = o2.getName();
                return fileName1.compareTo(fileName2);
            }
        });

        fileList.remove(new File(resultFileAbsolutePath));

        //Path resFile = Paths.get(resultFileAbsolutePath);
        //Path renamedFile = Files.move(resFile, resFile.resolveSibling("allFilesContent.txt"));

        File resultFile = new File(resultFileAbsolutePath);
        File allFilesContent = new File(resultFile.getParent() + "/allFilesContent.txt");
        resultFile.renameTo(allFilesContent);

        //BufferedWriter writer = new BufferedWriter(new FileWriter(renamedFile.toFile()));

        BufferedWriter writer = new BufferedWriter(new FileWriter(allFilesContent));

        for (File file :fileList){
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while(reader.ready()){
                writer.write(reader.readLine());
                writer.newLine();
            }
            reader.close();
        }
        writer.close();
    }

    public static void scanDirectory(File path){
        for(File file : path.listFiles()){

            if(file.isDirectory()){
                if(file.listFiles().length>0){
                    scanDirectory(file);
                }
                else{
                    file.delete();
                }
            }
            else{
                if(file.length()>50){
                    file.delete();
                }
                else{
                    fileList.add(file);
                }
            }
        }
    }
}
