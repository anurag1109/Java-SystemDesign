package lld2.designPattern.creationalDP.prototype.copyConstructor;

import lombok.Getter;

@Getter
public class Student {

    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;

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
}
