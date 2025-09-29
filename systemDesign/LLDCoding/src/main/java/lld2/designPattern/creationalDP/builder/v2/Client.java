package lld2.designPattern.creationalDP.builder.v2;

public class Client {
    public static void main(String[] args) {

        Helper student = Student.createHelper();// builder object is created
        // by student class now ie its static method and is reponsibility of student
        // class to create helper object( in v1 it was client responsibility to create
        // helper object)
        student.setName("sinan");
        student.setAge(30);
        student.setAddress("address");
        student.setPhone("1234567890");
        // helper.setEmail(123);// compile time error
        student.setEmail("helper@gmail.com");

        // still client is creating student object but it is responsibility of student
        // class to create student object
        Student student2 = new Student(student);

    }
}
