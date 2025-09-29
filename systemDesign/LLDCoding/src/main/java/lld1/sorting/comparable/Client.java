package lld1.sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.addAll(List.of(
                new Student("Alice", 22, 101),
                new Student("Charlie", 23, 103),
                new Student("Bob", 20, 102)));

        // this sorting will only work if Student class implements Comparable interface
        // because by default it does not know how to compare two Student objects
        // if we try to run this code without implementing Comparable interface in
        // Student class it will throw java.lang.ClassCastException: Student cannot be
        // cast to java.lang.Com
        System.out.println("Comparator Sorting by age");

        Collections.sort(list);
        list.forEach(student -> System.out.println(student.getName() + " " + student.getAge() + " " + student.getId()));

        // but what if i want to sort it by name => then we have to create another class
        // that implements Comparator interface(not Comparable)

        System.out.println("Comparable Sorting by name");

        Collections.sort(list, new comparatorsSortByName());
        list.forEach(student -> System.out.println(student.getName() + " " + student.getAge() + " " + student.getId()));

        System.out.println("Comparable Sorting by Id");

        Collections.sort(list, new ComparatorSortById());
        list.forEach(student -> System.out.println(student.getName() + " " + student.getAge() + " " + student.getId()));

        // we can create multiple comparator classes to sort by different attributes
        // without changing the Student class

        // two way of sorting is there-
        // 1. Inbuilt/bydefault sorting using Comparable interface
        // 2. Custom sorting using Comparator interface

        // Comparable interface has a method compareTo(o) that takes one object
        // and returns an int
        // comarator interface has a method compare(o1,o2) that takes two objects
        // and returns an int
    }

}
