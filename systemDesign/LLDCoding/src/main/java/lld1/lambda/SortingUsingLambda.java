package lld1.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lld1.sorting.comparable.Student;

public class SortingUsingLambda {

    public static void main(String[] args) {

        // using comparable to sort a list of strings
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

        // using comparator interface to sort by name using lambda expression
        System.out.println("Comparator Sorting by name using lambda");

        Comparator<Student> sortByName = (Student s1, Student s2) -> s1.getName().compareTo(s2.getName());
        // using lambda expression we don't need to create a separate class that
        // implements Comparator interface to sort by name like we did earlier in sorting package
        Collections.sort(list, sortByName);
        list.forEach(student -> System.out.println(student.getName() + " " + student.getAge() + " " + student.getId()));

    }

}
