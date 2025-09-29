package lld2.designPattern.creationalDP.prototype.copyConstructor;

import lombok.Getter;

@Getter
public class IntelligentStudent extends Student {
    private String iq;

    public IntelligentStudent(String name, int age, String address, String phone, String email, String iq) {
        super(name, age, address, phone, email);
        this.iq = iq;
    }

    // copy constructor
    public IntelligentStudent(IntelligentStudent ist) {
        super(ist); // call parent class copy constructor
        this.iq = ist.iq;
    }

}
