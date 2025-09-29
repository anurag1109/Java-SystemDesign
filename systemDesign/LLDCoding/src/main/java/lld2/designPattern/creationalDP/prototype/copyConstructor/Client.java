package lld2.designPattern.creationalDP.prototype.copyConstructor;

public class Client {
    public static void main(String[] args) {
        Student student1 = new Student("John", 20, "123 Street", "1234567890", "example@gmail.com");
        Student student2 = new Student(student1);// copy constructor

        IntelligentStudent intelligentStudent1 = new IntelligentStudent("Doe", 22, "456 Avenue", "0987654321",
                "example@gmail.com", "Math");
        IntelligentStudent intelligentStudent2 = new IntelligentStudent(intelligentStudent1);// copy constructor
    }
}
