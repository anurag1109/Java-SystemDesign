package lld2.designPattern.creationalDP.builder.v4;

public class Client {
    public static void main(String[] args) {
        Student student = Student.createHelper()// create helper object
                .setName("sinan")// assigning values
                .setAge(30)// chaining
                .setAddress("address")// chaining
                .setPhone("1234567890")
                .setEmail("email@gmail.com")
                .build();// to create student object

        // here client is not creating helper object and also not creating student
        // object directly

        // student class is responsible for creating helper object
        // so client is only responsible for setting values
        // and student class is responsible for creating student object
        // using build() method of helper class
    }
}
