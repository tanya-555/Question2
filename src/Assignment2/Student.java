package Assignment2;

import java.io.Serializable;
import java.util.*;

class Student implements Serializable {

    private String name;
    private int age;
    private String address;
    private int rollno;
    private Set<Character> courses = new HashSet<Character>();

    Student(String name, int age, String address, int rollno, Set<Character> courses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollno = rollno;
        this.courses = courses;
    }

    String getName() {

        return name;
    }

    int getAge() {

        return age;
    }

    int getRollno() {

        return rollno;
    }

    String getAddress() {

        return address;
    }

    Set<Character> getCourses() {

        return courses;
    }
}
