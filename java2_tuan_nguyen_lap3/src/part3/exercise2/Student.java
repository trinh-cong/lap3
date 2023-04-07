package part3.exercise2;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Student {
    private String name;
    private int age;
    private double mark;
    public Student(String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    // Convert the Student object to a string representation for writing to a file
    @Override
    public String toString() {
        return name + "\t" + age + "\t" + mark;
    }
}

