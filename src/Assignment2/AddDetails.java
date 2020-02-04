package Assignment2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class AddDetails {
    Scanner scanner = new Scanner(System.in);
    static Set<Integer> rollSet = new HashSet<Integer>();
    //list of constants
    private static final String NAME = "Enter Full Name";
    private static final String AGE = "Enter age";
    private static final String ADDRESS = "Enter address";
    private static final String ROLL_NO = "Enter Roll number";
    private static final String MISSING_NAME_FIELD = "Name field is mandatory!";
    private static final String MISSING_ADDRESS_FIELD = "Address field is mandatory!";
    private static final String INVALID_AGE = "Enter a valid age!";
    private static final String UNIQUE_ROLL_NO = "Enter a unique roll number";
    private static final String INVALID_ROLL_NO = "Enter a valid roll number";
    private static final String COURSE_LIST = "Enter any 4 courses from the given 6 options - ( A,B,C,D,E,F ) without space ( ex: ACDE)";
    private static final String INVALID_COURSE = "Enter a valid course name!";
    private static final String DISTINCT_COURSES = "Enter all 4 distict courses!";

    Student addStudent() {
        String name = "";
        String address = "";
        int rollno = 0;
        int age = 0;
        Set<Character> courses = new HashSet<Character>();

        name = addStudentName();
        age = addStudentAge();
        address = addStudentAddress();
        rollno = addStudentRollNumber();
        courses = addCourses();

        Student student = new Student(name, age, address, rollno, courses);
        return student;
    }

    String addStudentName() {
        System.out.println(NAME);
        String name = scanner.next();
        name += scanner.nextLine();
        if (name == "") {
            System.out.println(MISSING_NAME_FIELD);
            System.exit(0);
        }
        return name;
    }

    int addStudentAge() {
        System.out.println(AGE);
        int age = 0;
        try {
            age = Integer.parseInt(scanner.next());
        } catch (NumberFormatException e) {
            System.out.println(INVALID_AGE);
            System.out.println("Do you want to exit? (y/n)");
            char choice = scanner.next().charAt(0);
            if(choice == 'y') {
                System.exit(0);
            }
            else {
                age = addStudentAge();
            }
        }
        return age;
    }

    String addStudentAddress() {
        System.out.println(ADDRESS);
        String address = scanner.next();
        address += scanner.nextLine();
        if (address == "") {
            System.out.println(MISSING_ADDRESS_FIELD);
            System.exit(0);
        }
        return address;
    }

    int addStudentRollNumber() {
        System.out.println(ROLL_NO);
        int rollno = 0;
        try {
            rollno = Integer.parseInt(scanner.next());
            if (rollSet.contains(rollno)) {
                System.out.println(UNIQUE_ROLL_NO);
                System.exit(0);
            } else {
                rollSet.add(rollno);
            }
        } catch (NumberFormatException e) {
            System.out.println(INVALID_ROLL_NO);
            System.out.println("do you want to exit? (y/n)");
            char choice = scanner.next().charAt(0);
            if(choice == 'y') {
                System.exit(0);
            } else {
                rollno = addStudentRollNumber();
            }
        }
        return rollno;
    }

    Set<Character> addCourses() {

        Set<Character> courses = new HashSet<Character>();
        System.out.println(COURSE_LIST);

        String course_list = scanner.next();
        course_list += scanner.nextLine();
        char[] courses_array = course_list.toCharArray();
        courses.add(courses_array[0]);

        int index = 1;
        while (index < 4) {
            if(courses_array[index] != 'A' && courses_array[index]!='B' && courses_array[index]!='C' && courses_array[index]!='D' && courses_array[index]!='E') {
                System.out.println(courses_array[index]);
                System.out.println(INVALID_COURSE);
            }
            if(courses.contains(courses_array[index])) {
                System.out.println(DISTINCT_COURSES);
                index = index +1;
            } else {
                courses.add(courses_array[index]);
                index = index+1;
            }
        }
        return courses;
    }
}
