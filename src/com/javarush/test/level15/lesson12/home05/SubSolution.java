package com.javarush.test.level15.lesson12.home05;


public class SubSolution extends Solution
{
    public SubSolution(){

    }
    public SubSolution(int h){
        super(h);
    }
    public SubSolution (double h){
        super(h);
    }

    protected SubSolution (String g, String h) {
        super(g,h);
    }
    protected SubSolution (String f, int r){
        super(f,r);
    }
    protected SubSolution (String g, double f){
        super(g, f);
    }
    SubSolution (int g, double j){
        super(g,j);
    }
    SubSolution (double d, int r){
        super(d,r);
    }
    SubSolution (double f, char t){
        super(f,t);
    }
    private SubSolution (char t){}
    private SubSolution (int h, int g){}
    private SubSolution(int g, String h){}
}
