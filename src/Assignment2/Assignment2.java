package Assignment2;

import java.util.*;
import java.io.*;

public class Assignment2 {
    private static final long serialVersionUID = 18L;
    static File filename = new File("details.ser");

    //list of constants
    private static final String INVALID_CHOICE = "Invalid Choice!";
    private static final String INVALID_ORDER = "Invalid Order!";
    private static final String INVALID_INPUT = "Invalid Input!";

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ArrayList<Student> studentList = new ArrayList<Student>();
        if (filename.length() != 0) {
            studentList = loadDetails();
        }
        int choice = 0;
        while (choice != 5) {
            System.out.println("MENU \n 1. Add User Details \n 2. Display User Details \n 3. Delete User Details \n 4. Save User Details \n 5. Exit \n Enter your choice:");
            try {
                choice = Integer.parseInt(scanner.next());
                if (choice < 1 || choice > 5) {
                    System.out.println(INVALID_CHOICE);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(INVALID_CHOICE);
                System.exit(0);
            }
            switch (choice) {
                case 1:
                    AddDetails add_details = new AddDetails();
                    Student student_detail = add_details.addStudent();
                    studentList.add(student_detail);
                    compareList comparison = new compareList();
                    comparison.setField(1);
                    Collections.sort(studentList, comparison);
                    break;

                case 2:
                    DisplayDetails display_details = new DisplayDetails();
                    display_details.display(studentList);
                    displayInSortedOrder(studentList, display_details);

                    break;
                case 3:
                    DeleteEntry delete_details = new DeleteEntry();
                    studentList = delete_details.deleteDetails(studentList);
                    break;
                case 4:
                    SaveToDisk save_details = new SaveToDisk();
                    save_details.saveDetails(filename, studentList);
                    break;
                case 5:
                    System.out.println("Do you want to save the latest changes? (y/n)");
                    char save_changes = scanner.next().charAt(0);
                    if (save_changes == 'y') {
                        SaveToDisk save_detail = new SaveToDisk();
                        save_detail.saveDetails(filename, studentList);
                        System.exit(0);
                    } else if (save_changes != 'n') {
                        System.out.println(INVALID_INPUT);
                    }
                    System.exit(0);
                    break;
            }
        }

    }

    private static void displayInSortedOrder(ArrayList<Student> studentList, DisplayDetails display_details) {
        System.out.println("Do you want to display result in sorted manner -(y/n):");
        char sort_choice = scanner.next().charAt(0);
        if (sort_choice == 'y') {
            ArrayList<Student> temp = new ArrayList<Student>(studentList);
            System.out.println("Select field for sorting: \n 1. name \n 2. age \n 3. address \n 4. roll number");
            try {
                int sort_field = Integer.parseInt(scanner.next());
                compareList compare_list = new compareList();
                compare_list.setField(sort_field);

                System.out.println("Select Order\n1.Ascending 2.Descending");
                int order = Integer.parseInt(scanner.next());
                if (order == 1) {
                    Collections.sort(temp, compare_list);
                    display_details.display(temp);
                } else if (order == 2) {
                    Collections.sort(temp, compare_list);
                    Collections.reverse(temp);
                    display_details.display(temp);

                } else {
                    System.out.println(INVALID_ORDER);
                }

            } catch (NumberFormatException e) {
                System.out.println(INVALID_INPUT);
            }
        }
    }

    private static ArrayList<Student> loadDetails() throws IOException, ClassNotFoundException {
        ArrayList<Student> temp = new ArrayList<Student>();
        FileInputStream file = null;
        ObjectInputStream in = null;

        //pre populating the data stored on the disk
        try {
            file = new FileInputStream(filename);
            in = new ObjectInputStream(file);
            temp = (ArrayList<Student>) in.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (file != null) {
                file.close();
            }
            return temp;
        }
    }

}

