package lld2.designPattern.creationalDP.prototype.copyPrototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public IntelligentStudent copy() {
        // IntelligentStudent ist = new IntelligentStudent(this.getName(),
        // this.getAge(), this.getAddress(), this.getPhone(), this.getEmail(), this.iq);
        IntelligentStudent ist = new IntelligentStudent(this);

        return ist;

    }

}
