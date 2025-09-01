package lld1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    protected int age;
    String city;// it is default access modifier
    public String universityName;

    public Student(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;

    }

    public Student() {

    }

    public static void main(String[] args) {
        // checking access modifiers from same package, same file--------------------
        Student student = new Student();
        student.name = "Bob"; // Allowed: name has private access in Student, same class
        student.age = 21; // Allowed: age has protected access in Student, same class
        student.city = "Chicago"; // Allowed: city has default access in Student, same class
        student.universityName = "Scalar University"; // Allowed: universityName has public access
        System.out.println(student.name);
    }

}
