package Assignment2;

import java.util.Comparator;

class compareByName implements Comparator<Student> {
    @Override
    public int compare(Student obj1, Student obj2) {
        int res = obj1.getName().compareTo(obj2.getName());
        if (res == 0) {
            return obj1.getRollno() - obj2.getRollno();
        }
        return res;
    }
}
