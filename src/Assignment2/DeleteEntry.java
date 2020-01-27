package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

class DeleteEntry {

    //LIST OF CONSTANTS
    private static final String CHOOSE_STUDENT = "Enter roll number of the student whose details are to be deleted:";
    private static final String DELETED_ENTRY = "Entry Deleted";
    private static final String INVALID_ROLL = "No student with the entered roll number!";
    private static final String INVALID_INPUT = "Invalid Input!";

    ArrayList<Student> deleteDetails(ArrayList<Student> st) {
        Scanner sc = new Scanner(System.in);
        System.out.println(CHOOSE_STUDENT);
        try {
            int roll = Integer.parseInt(sc.next());
            int flag = 0;
            for (Student s : st) {
                if (roll == s.getRollno()) {
                    st.remove(s);
                    System.out.println(DELETED_ENTRY);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println(INVALID_ROLL);
            }
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT);
            System.exit(0);
        }
        return st;
    }
}
