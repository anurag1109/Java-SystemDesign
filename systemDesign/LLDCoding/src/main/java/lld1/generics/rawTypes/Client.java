package lld1.generics.rawTypes;

public class Client {

    public static void doSomething(Pair p) {
        // here we dont know what type of objects are being passed => not type safe
        // will work at compile time but can lead to runtime exceptions => this proble
        // is solved by generics
        Object first = p.getFirst();
        Object second = p.getSecond();
        System.out.println("Doing something with: " + first + " and " + second);
    }

    public static void main(String[] args) {
        Pair p1 = new Pair("Hello", 123);

        Object obj1 = p1.getFirst();
        Object obj2 = p1.getSecond();
        // we have to typecast to perform operations as it is of type Object
        // int sum = obj2 + 100;
        int sum1 = (Integer) obj2 + 100;
        System.out.println("Sum: " + sum1);

        // directly typescasting
        String first = (String) p1.getFirst();
        Integer second = (Integer) p1.getSecond();
        int sum2 = second + 200;
        System.out.println("Sum2: " + sum2);

        // typecasting is not a good practice
        // as it is error-prone and can lead to runtime exceptions
        // also it is not safe when we are passing this value to a function where we
        // wont know exactly what type of object is being passed
        // so we use generics to solve this problem
        // Example

        doSomething(p1);

        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }

}
