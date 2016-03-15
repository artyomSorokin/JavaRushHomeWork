package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
   public Solution(){}
    public Solution(int h){}
    public Solution (double h){}
    private Solution (char t){}
    private Solution (int h, int g){}
    private Solution(int g, String h){}
    protected Solution (String g, String h) {}
    protected Solution (String f, int r){}
    protected Solution (String g, double f){}
    Solution (int g, double j){}
    Solution (double d, int r){}
    Solution (double f, char t){}

}

