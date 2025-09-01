package lld1.inheitance;

public class B extends A {
    B() {
        System.out.println("B Constructer");
    }

    B(String msg) {
        super();
        System.out.println("B Constructer got a msg: " + msg);
    }

}
