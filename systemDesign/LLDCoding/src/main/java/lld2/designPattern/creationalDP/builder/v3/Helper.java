package lld2.designPattern.creationalDP.builder.v3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Helper {

    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;

    // build method to create student object
    // here this refers to current helper object
    public Student build() {
        return new Student(this);
    }
}
