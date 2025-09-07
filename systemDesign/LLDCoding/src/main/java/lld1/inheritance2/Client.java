package lld1.inheritance2;

public class Client {
    public static void main(String[] args) {
        C d1 = new D();
        System.out.println(d1.x);
        System.out.println(d1.y);
        d1.doSomething();

    }

}

// Fields: Compile-time, based on reference type (C).
// Methods: Run-time, based on actual object type (D).

// C d1 = new D(...); means d1.x and d1.y use the definitions from class C, not D, even though the object is actually a D
// d1.doSomething() calls the overridden method in D, because the object is a D.
