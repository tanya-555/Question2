package Assignment2;

import java.util.ArrayList;

class DisplayDetails {
    void display(ArrayList<Student> st) {

        System.out.println("Name\t\tAge\t\tRoll number\t\t\tAddress\t\t\tCourse");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Student s : st) {

            String result = String.format("%3s %10d %10d %20s %20s", s.getName(), s.getAge(), s.getRollno(), s.getAddress(), s.getCourses());
            System.out.println(result);
            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
}