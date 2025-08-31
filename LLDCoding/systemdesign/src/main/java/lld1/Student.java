package lld1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    private int age;
    String city;

    public Student(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;

    }

    public Student() {

    }

}
