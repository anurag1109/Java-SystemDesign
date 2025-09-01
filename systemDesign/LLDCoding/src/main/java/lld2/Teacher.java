package lld2;

import lld1.Student;

public class Teacher {
    public static void main(String[] args) {

        // checking access modifiers from different package-------------------------
        Student student1 = new Student();
        // student1.name = "Bob"; // Error: name has private access in Student
        // student1.age = 21; // Error: age has protected access in Student
        // student1.city="Chicago"; // Not Allowed from different package: city has
        // default access modifier
        student1.universityName = "Scalar University"; // Allowed: universityName has public access
    }
}
