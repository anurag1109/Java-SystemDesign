package lld1.inheitance;

public class D extends C {

    D() {
        System.out.println("D Constructer");
    }

    D(String msg) {
        super(msg);
        System.out.println("D Constructer got a msg: " + msg);
    }

}
