package lld2.designPattern.creationalDP.builder.v4;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;

    // make constructor private to stop creating student object in client without
    // using build()
    private Student(Helper helper) {
        this.name = helper.getName();
        this.age = helper.getAge();
        this.address = helper.getAddress();
        this.phone = helper.getPhone();
        this.email = helper.getEmail();
    }

    // to create helper object
    public static Helper createHelper() {
        return new Helper();
    }

    // static nested class
    // it is here to access private constructor of outer class Student
    // and also to logically group builder class with the class it builds
    @Getter
    public static class Helper {
        // we need helper class to set values and then pass it to student constructor
        // as there are many parameters in student constructor
        // it is basically for validation of data before creating student object
        // and also to avoid telescoping constructor problem
        private String name;
        private int age;
        private String address;
        private String phone;
        private String email;

        public Helper setName(String name) {
            this.name = name;
            return this;// to return current object for chaining
        }

        public Helper setAge(int age) {
            this.age = age;
            return this;// to return current object for chaining
        }

        public Helper setAddress(String address) {
            this.address = address;
            return this;// to return current object for chaining
        }

        public Helper setPhone(String phone) {
            this.phone = phone;
            return this;// to return current object for chaining
        }

        public Helper setEmail(String email) {
            this.email = email;
            return this;// to return current object for chaining
        }

        // validation method
        public boolean validate() {
            // validation logic
            if (this.age < 0) {
                return false;
            }
            return true;
        }

        // to create student object
        public Student build() {
            if (!validate()) {
                throw new IllegalStateException("Invalid data");
            }
            return new Student(this);
        }
    }

}
