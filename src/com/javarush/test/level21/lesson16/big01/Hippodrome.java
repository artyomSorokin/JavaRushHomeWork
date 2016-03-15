package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

public class Hippodrome
{
    public static Hippodrome game;
    public static ArrayList<Horse> horses = new ArrayList<Horse>();
    public static void main(String[] args)
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Belka", 3, 0));
        game.getHorses().add(new Horse("Strelka", 3, 0));
        game.getHorses().add(new Horse("Burka", 3, 0));
        game.run();
        game.printWinner();
    }


    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public  void run() {
   for(int i=0;i<100;i++){
    move();
    print();
       try {
           Thread.sleep(200);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
        }
    }
    public void move(){
    for(Horse h : horses){
    h.move();
    }
    }
    public void print(){
    for(Horse h : horses){
    h.print();
        }
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
       Horse horseWin=null;
        double dist=0;
        for(Horse h:horses){
            if(h.distance>dist) dist = h.distance;
        }
        for(Horse h: horses){
           if(h.distance==dist) horseWin=h;
        }
        return horseWin;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName()+"!");
    }

}
