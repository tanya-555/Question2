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

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<Student>();
        if (filename.length() != 0) {
            studentList = loadDetails();
        }
        int choice = 0;
        while (choice != 5) {
            System.out.println("MENU \n 1. Add User Details \n 2. Display User Details \n 3. Delete User Details \n 4. Save User Details \n 5. Exit \n Enter your choice:");
            try {
                choice = Integer.parseInt(sc.next());
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
                    AddDetails obj1 = new AddDetails();
                    Student st = obj1.addStudent();
                    studentList.add(st);
                    Collections.sort(studentList, new compareByName());
                    break;
                case 2:
                    DisplayDetails obj2 = new DisplayDetails();
                    obj2.display(studentList);
                    System.out.println("Do you want to display result in sorted manner -(y/n):");
                    char ch = sc.next().charAt(0);
                    if (ch == 'y') {
                        ArrayList<Student> temp = new ArrayList<Student>(studentList);
                        System.out.println("Select field for sorting: \n 1. name \n 2. age \n 3. address \n 4. roll number");
                        try {
                            int field = Integer.parseInt(sc.next());
                            compareList cl = new compareList();
                            cl.setField(field);
                            //sorting the list
                            System.out.println("Select Order\n1.Ascending 2.Descending");
                            int order = Integer.parseInt(sc.next());
                            if (order == 1) {
                                Collections.sort(temp, cl);
                                obj2.display(temp);
                            } else if (order == 2) {
                                Collections.sort(temp, cl);
                                Collections.reverse(temp);
                                obj2.display(temp);

                            } else {
                                System.out.println(INVALID_ORDER);
                            }

                        } catch (NumberFormatException e) {
                            System.out.println(INVALID_INPUT);
                        }
                    }
                    break;
                case 3:
                    DeleteEntry obj3 = new DeleteEntry();
                    studentList = obj3.deleteDetails(studentList);
                    break;
                case 4:
                    SaveToDisk obj4 = new SaveToDisk();
                    obj4.saveDetails(filename, studentList);
                    break;
                case 5:
                    System.out.println("Do you want to save the latest changes? (y/n)");
                    char save_changes = sc.next().charAt(0);
                    if (save_changes == 'y') {
                        SaveToDisk obj5 = new SaveToDisk();
                        obj5.saveDetails(filename, studentList);
                        System.exit(0);
                    } else if (save_changes != 'n') {
                        System.out.println(INVALID_INPUT);
                    }
                    System.exit(0);
                    break;
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
            in.close();
            file.close();
            return temp;
        }
    }

}

