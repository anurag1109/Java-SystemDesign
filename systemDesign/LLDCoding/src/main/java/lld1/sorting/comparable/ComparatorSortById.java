package lld1.sorting.comparable;

import java.util.Comparator;

public class ComparatorSortById implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.getId() - s2.getId();
    }
}
