package lld2.designPattern.creationalDP.builder.v3;

public class Student {

    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;

    public Student(Helper helper) {
        this.name = helper.getName();
        this.age = helper.getAge();
        this.address = helper.getAddress();
        this.phone = helper.getPhone();
        this.email = helper.getEmail();
    }

    public static Helper createHelper() {
        return new Helper();
    }



}
