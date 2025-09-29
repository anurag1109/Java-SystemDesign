package lld1.sorting.comparable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int Id;

    public Student(String name, int age, int Id) {
        this.name = name;
        this.age = age;
        this.Id = Id;
    }

    public int compareTo(Student other) {
        // assending order by age
        if (this.age < other.age) {
            return -1;
        } else if (this.age > other.age) {
            return 1;
        } else {
            return 0;
        }
    }

}
