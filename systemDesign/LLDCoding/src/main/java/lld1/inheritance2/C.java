package lld1.inheritance2;

public class C {
    int x = 100;
    int y = 200;

    public void doSomething() {
        System.out.println("Doing something in C");
    }

    C() {
        System.out.println("C Constructer");
    }

    C(String msg) {
        System.out.println("C Constructer got a msg: " + msg);
    }

}
