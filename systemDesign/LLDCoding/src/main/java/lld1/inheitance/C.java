package lld1.inheitance;

public class C extends B {
    C() {
        System.out.println("C Constructer");
    }

    C(String msg) {
        super("Hello from C");
        // super();
        System.out.println("C Constructer got a msg: " + msg);
    }

}
