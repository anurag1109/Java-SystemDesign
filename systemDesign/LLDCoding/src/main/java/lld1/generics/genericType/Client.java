package lld1.generics.genericType;

public class Client {

    public static void doSomething(Pair<Integer, String> p) {
        // here we know exactly what type of objects are being passed
        Integer first = p.getFirst();
        String second = p.getSecond();
        System.out.println("Doing something with: " + first + " and " + second);
    }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "One");
        // here we know exactly what type of objects are being passed => type safe
        // will give error at compile time if we try to pass different type of objects
        Integer first = p1.getFirst();
        String second = p1.getSecond();
        int sum = first + 100;
        System.out.println("Sum: " + sum);

        Pair<String, String> p2 = new Pair<>("Hello", "World");
        String first2 = p2.getFirst();
        String second2 = p2.getSecond();

        doSomething(p1);
        // doSomething(p2); // will give error as p2 is of type Pair<String, String>

        // -----------------------------------------------------------------------

        // Raw types - not recommended to use
        // used in java 3 - before generics in java 5 were introduced
        Pair p3 = new Pair(1, "One");// need not to specify type parameters
        // in raw types, we lose the type safety as it behaves like Pair<Object, Object>
        // int sum3 = p3.getSecond() + 100; // 
        // will give error as getSecond() returns sObject

        // to solve this we have to typecast
        int sum3 = (Integer) p3.getFirst() + 100;
        System.out.println("Sum3: " + sum3);

        System.out.println("First: " + p3.getFirst());
        System.out.println("Second: " + p3.getSecond());

        // Raw data is supported in java5 for backward compatibility ie old code will
        // still work
        // so everything is Object by default in raw types
    }

}
