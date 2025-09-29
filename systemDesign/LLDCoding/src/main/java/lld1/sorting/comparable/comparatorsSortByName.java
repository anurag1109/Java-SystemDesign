package lld1.sorting.comparable;

import java.util.Comparator;

public class comparatorsSortByName implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
    
}
