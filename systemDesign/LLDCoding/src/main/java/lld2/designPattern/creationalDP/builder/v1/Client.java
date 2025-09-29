package lld2.designPattern.creationalDP.builder.v1;

public class Client {
    public static void main(String[] args) {

        Helper student = new Helper();
        student.setName("sinan");
        student.setAge(30);
        student.setAddress("address");
        student.setPhone("1234567890");
        // student.setEmail(123);// compile time error
        student.setEmail("student@gmail.com");

        Student student1 = new Student(student);

    }
}
