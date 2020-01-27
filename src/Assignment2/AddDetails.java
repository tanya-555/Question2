package Assignment2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class AddDetails {
    Scanner sc = new Scanner(System.in);
    static Set<Integer> rollSet = new HashSet<Integer>();
    //list of constants
    private static final String NAME = "Enter Full Name";
    private static final String AGE = "Enter age";
    private static final String ADDRESS = "Enter address";
    private static final String ROLL_NO = "Enter Roll number";
    private static final String COURSE = "Enter course";
    private static final String MISSING_NAME_FIELD = "Name field is mandatory!";
    private static final String MISSING_ADDRESS_FIELD = "Address field is mandatory!";
    private static final String INVALID_AGE = "Enter a valid age!";
    private static final String UNIQUE_ROLL_NO = "Enter a unique roll number";
    private static final String INVALID_ROLL_NO = "Enter a valid roll number";
    private static final String COURSE_LIST = "Enter any 4 courses from the given 6 options - A,B,C,D,E,F";
    private static final String INVALID_COURSE = "Enter a valid course name!";
    private static final String SELECTED_COURSE = "Course already selected!";

    Student addStudent() {
        String name = "";
        String address = "";
        int rollno = 0;
        int age = 0;
        Set<Character> courses = new HashSet<Character>();
        System.out.println(NAME);
        name = sc.nextLine();
        if (name == "") {
            System.out.println(MISSING_NAME_FIELD);
            System.exit(0);
        }
        System.out.println(AGE);
        try {
            age = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println(INVALID_AGE);
            System.exit(0);
        }
        System.out.println(ADDRESS);
        address = sc.next();
        address += sc.nextLine();
        if (address == "") {
            System.out.println(MISSING_ADDRESS_FIELD);
            System.exit(0);
        }
        System.out.println(ROLL_NO);
        try {
            rollno = Integer.parseInt(sc.next());
            if (rollSet.contains(rollno)) {
                System.out.println(UNIQUE_ROLL_NO);
                System.exit(0);
            } else {
                rollSet.add(rollno);
            }
        } catch (NumberFormatException e) {
            System.out.println(INVALID_ROLL_NO);
            System.exit(0);
        }
        System.out.println(COURSE_LIST);
        int count = 1;
        char ch;
        while (count <= 4) {
            System.out.println(COURSE);
            ch = sc.next().charAt(0);
            if (ch != 'A' && ch != 'B' && ch != 'C' && ch != 'D' && ch != 'E' &&
                    ch != 'F') {
                System.out.println(INVALID_COURSE);
            } else {
                if (courses.contains(ch)) {
                    System.out.println(SELECTED_COURSE);
                } else {
                    count = count + 1;
                    courses.add(ch);
                }
            }

        }
        Student obj = new Student(name, age, address, rollno, courses);
        return obj;
    }
}
