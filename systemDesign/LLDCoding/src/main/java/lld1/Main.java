package lld1;

public class Main {

    public static void main(String[] args) {
        // Student 1
        Student student1 = new Student();

        student1.setName("John");
        student1.setAge(20);

        System.out.println("Student Name: " + student1.getName());
        System.out.println("Student Age: " + student1.getAge());

        System.out.println("-----------------------");

        // Student 2
        Student student2 = new Student("John", 20, "New York");

        System.out.println("Student Name: " + student2.getName());
        System.out.println("Student Age: " + student2.getAge());
        System.out.println("Student City: " + student2.getCity());

        student2.setName("Alice");
        student2.setAge(22);
        student2.setCity("Los Angeles");
        student2.city = "San Francisco"; // Direct access topackage-public field

        System.out.println("Updated Student Name: " + student2.getName());
        System.out.println("Updated Student Age: " + student2.getAge());
        System.out.println("Updated Student City: " + student2.getCity());
        System.out.println("Updated Student City (direct access): " + student2.city);

        System.out.println("-----------------------");
    }
}