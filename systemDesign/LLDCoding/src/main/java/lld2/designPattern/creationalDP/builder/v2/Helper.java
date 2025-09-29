package lld2.designPattern.creationalDP.builder.v2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// we need helper class to set values and then pass it to student constructor
// as there are many parameters in student constructor
// it is basically for validation of data before creating student object
// and also to avoid telescoping constructor problem
public class Helper {

    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;

}
