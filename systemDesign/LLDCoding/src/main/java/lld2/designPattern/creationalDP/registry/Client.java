package lld2.designPattern.creationalDP.registry;

public class Client {

    public static void fillRegistry(StudentRegistry registry) {
        Student student1 = new Student();// prototype
        student1.setAddress("FZD");
        registry.add("student1", student1);

        IntelligentStudent student2 = new IntelligentStudent();// prototype
        student2.setAddress("FZD");
        student2.setIq("Math");
        registry.add("student2", student2);
    }

    public static void main(String[] args) {
        // Student student1 = new Student("John", 20, "123 Street", "1234567890",
        // "example@gmail.com");// prototype
        // Student student2 = student1.copy();// copy constructor
        // student2.setAge(90);// change specific attribute if needed

        // System.out.println(student2.getName());
        // System.out.println(student2.getAge());
        // System.out.println(student2.getAddress());

        // IntelligentStudent intelligentStudent1 = new IntelligentStudent("Doe", 22,
        // "456 Avenue", "0987654321",
        // "example@gmail.com", "Math");
        // IntelligentStudent intelligentStudent2 = intelligentStudent1.copy();// copy
        // constructor
        // System.out.println(intelligentStudent2.getName());
        // System.out.println(intelligentStudent2.getAge());
        // System.out.println(intelligentStudent2.getAddress());
        // System.out.println(intelligentStudent2.getIq());

        // Student intelligentStudent3 = new IntelligentStudent("Doe", 22, "456 Avenue",
        // "0987654321",
        // "example@gmail.com", "Math");
        // Student intelligentStudent4 = intelligentStudent3.copy();// copy constructor
        // System.out.println(intelligentStudent4.getName());
        // System.out.println(intelligentStudent4.getAge());

        StudentRegistry registry = new StudentRegistry();
        fillRegistry(registry);

        Student student1 = registry.get("student1").copy();
        student1.setName("sinan");
        student1.setAge(30);

        Student student2 = registry.get("student2");
        student2.setName("ali");
        student2.setAge(40);

        System.out.println(student1.getName());

    }
}
