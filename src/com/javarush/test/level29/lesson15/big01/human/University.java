package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University  {

    private List<Student> students = new ArrayList<Student>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student studentNeed = null;
        for(Student student : students){
            if(student.getAverageGrade() == averageGrade){
                studentNeed = student;
                break;
            }
        }
        return studentNeed;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student betterStudent=null;
        double maxAverageGrade = 0;
        for (Student student : students){
            double averageGrade = student.getAverageGrade();
            if(averageGrade>maxAverageGrade){
                maxAverageGrade=averageGrade;
                betterStudent = student;
            }
        }
        return betterStudent;
    }

    public Student getStudentWithMinAverageGrade()
    {
        Student worstStudent = null;
        double minAverageGrade = students.get(0).getAverageGrade();
        for (Student student : students)
        {
            double averageGrade = student.getAverageGrade();
            if (averageGrade < minAverageGrade)
            {
                minAverageGrade = averageGrade;
                worstStudent = student;
            }
        }
        return worstStudent;
    }

    public void expel(Student student){
        students.remove(student);
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
