package lld2.designPattern.creationalDP.prototype.copyMethod;

public class Client {
    public static void main(String[] args) {
        Student student1 = new Student("John", 20, "123 Street", "1234567890", "example@gmail.com");
        Student student2 = student1.copy();// copy constructor

        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());

        IntelligentStudent intelligentStudent1 = new IntelligentStudent("Doe", 22, "456 Avenue", "0987654321",
                "example@gmail.com", "Math");
        IntelligentStudent intelligentStudent2 = intelligentStudent1.copy();// copy constructor
        System.out.println(intelligentStudent2.getName());
        System.out.println(intelligentStudent2.getAge());
        System.out.println(intelligentStudent2.getAddress());
        System.out.println(intelligentStudent2.getIq());

        Student intelligentStudent3 = new IntelligentStudent("Doe", 22, "456 Avenue", "0987654321",
                "example@gmail.com", "Math");
        Student intelligentStudent4 = intelligentStudent3.copy();// copy constructor
        System.out.println(intelligentStudent4.getName());
        System.out.println(intelligentStudent4.getAge());
    }
}
