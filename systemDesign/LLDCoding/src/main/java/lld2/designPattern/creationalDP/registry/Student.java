package lld2.designPattern.creationalDP.registry;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student implements Prototype<Student> {

    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;

    public Student() {
    }

    public Student(String name, int age, String address, String phone, String email) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    // copy constructor
    public Student(Student st) {
        this.name = st.name;
        this.age = st.age;
        this.address = st.address;
        this.phone = st.phone;
        this.email = st.email;
    }

    public Student copy() {
        // Student st = new Student(this.name, this.age, this.address, this.phone,
        // this.email);
        Student st = new Student(this);
        // st.name = this.name;
        // st.age = this.age;
        // st.address = this.address;
        // st.phone = this.phone;
        // st.email = this.email;
        return st;
    }
}
