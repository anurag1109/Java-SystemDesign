package lld2.designPattern.creationalDP.builder.v3;

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

        // now client is not creating student object but using build() method of helper
        // class
        Student student2 = student.build();

        // still have problem that we are creating student object in client without
        // using build()
        Student student3 = new Student(student);
        Student student4 = new Student(student);

        // we have to stop this ie creating student object in client without using
        // build()
        // => have to make student constructor private

    }
}
