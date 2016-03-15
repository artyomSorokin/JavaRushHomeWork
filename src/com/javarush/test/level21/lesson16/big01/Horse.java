package com.javarush.test.level21.lesson16.big01;


public class Horse
{
    String name;
    double speed;
    double distance;

    public Horse(String name,double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance =distance;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
    public void move(){
    distance += speed*Math.random();
    }
    public void print(){
        for(int i=0;i<distance;i++){
            System.out.print(".");
        }
        System.out.print(getName());
    }
}
