package lld2;

import lld1.Student;

public class StudentChild extends Student {

    public static void main(String[] args) {
        // checking access modifiers from different package through object of child
        // class-------------------------------
        StudentChild studentChild = new StudentChild();
        // studentChild.name = "Bob"; // Error: name has private access in Student
        studentChild.age = 21; // Allowed: age has protected access in Student
        // studentChild.city="Chicago"; // Not Allowed from different package: city has
        // default access modifier
        studentChild.universityName = "Scalar University"; // Allowed: universityName has public access

        // checking access modifiers from different package through object of parent
        // class--------------------------------
        Student student1 = new Student();
        // student1.name = "Bob"; // Error: name has private access in Student
        // student1.age = 21; // Error: age has protected access in Student, even though
        // we are in child class, because we are trying to access through object of
        // parent class

        // student1.city = "Chicago"; // Not Allowed from different package: city has
        // default access modifier
        student1.universityName = "Scalar University"; // Allowed: universityName has public access
    }

}
