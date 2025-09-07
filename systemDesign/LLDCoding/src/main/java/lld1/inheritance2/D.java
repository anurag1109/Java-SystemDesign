package lld1.inheritance2;

public class D extends C {
    int x = 10;
    int y = 20;

    public void doSomething() {
        System.out.println("Doing something in D");
    }

    D() {
        System.out.println("D Constructer");
    }

    D(String msg) {
        super(msg);
        System.out.println("D Constructer got a msg: " + msg);
    }

}
