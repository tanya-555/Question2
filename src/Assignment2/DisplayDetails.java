package Assignment2;

import java.util.ArrayList;

class DisplayDetails {
    void display(ArrayList<Student> st) {
        System.out.println("Name\t\tAge\t\tRoll number\tAddress\t\t\tCourse");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Student s : st) {
            System.out.println(s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getRollno() + "\t\t" + s.getAddress() + "\t\t\t" + s.getCourses());
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
}