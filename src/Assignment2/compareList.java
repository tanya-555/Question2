package Assignment2;

import java.util.Comparator;

//compare two Student objects based on selected sorting field
class compareList implements Comparator<Student> {
    private int sortingField;

    @Override
    public int compare(Student obj1, Student obj2) {
        int diff = 0;
        switch (sortingField) {
            case 1:
                diff = obj1.getName().compareTo(obj2.getName());
                if(diff == 0) {
                    diff = obj1.getRollno() - obj2.getRollno();
                }
                break;
            case 2:
                diff = obj1.getAge() - obj2.getAge();
                break;
            case 3:
                diff = obj1.getAddress().compareTo(obj2.getAddress());
                break;
            case 4:
                diff = obj1.getRollno() - obj2.getRollno();
                break;
        }
        return diff;
    }

    void setField(int field) {

        this.sortingField = field;
    }
}