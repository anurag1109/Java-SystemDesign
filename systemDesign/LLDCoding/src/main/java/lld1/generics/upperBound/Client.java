package lld1.generics.upperBound;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        // here we can pass any type that is a ssuperclass of Integer
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        addIntegers(intList);

        List<Number> numList = List.of(1, 2, 3, 4, 5);
        addIntegers(numList);

        List<Object> objList = List.of(1, 2, 3, 4, 5);
        addIntegers(objList);
    }

    // generic method with bounded type
    public static <TYPE extends Number> double genericAVG(Triplet<TYPE> triplet) {
        TYPE first = triplet.getFirst();
        TYPE second = triplet.getSecond();
        TYPE third = triplet.getThird();
        return (first.doubleValue() + second.doubleValue() + third.doubleValue()) / 3;
    }

    // generic method with upper bounded wildcard(?)
    // ? extends Number means anything extends Number or any type that is Number or
    // a subclass of Number
    // here Number is the upper bound and ? is the wildcard
    // we use wildcard when we don't care about the type but we care about the upper
    // bound
    // we cannot use ? in the class level generic type declaration
    public static double upperBoundAVG(Triplet<? extends Number> triplet) {
        Number first = triplet.getFirst();
        Number second = triplet.getSecond();
        Number third = triplet.getThird();
        return (first.doubleValue() + second.doubleValue() + third.doubleValue()) / 3;
    }

    // similar to this comes lower bounded wildcard
    // ? super Integer means anything that is super of Integer or any type that is
    // Integer or a superclass of Integer
    // here Integer is the lower bound and ? is the wildcard
    // we use wildcard when we don't care about the type but we care about the lower
    // bound
    // we cannot use ? in the class level generic type declaration
    public static double lowerBoundAVG(Triplet<? super Integer> triplet) {
        Number first = (Number) triplet.getFirst();
        Number second = (Number) triplet.getSecond();
        Number third = (Number) triplet.getThird();
        return (first.doubleValue() + second.doubleValue() + third.doubleValue()) / 3;
    }

    // Example of lower bounded wildcard is when we want to add elements to a
    // collection
    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    // here is another example with classes

    // class Animal {}
    // class Dog extends Animal {}
    // class Cat extends Animal {}
    // if i want to add dogs to a list, i can use lower bounded wildcard
    // because if i want to add dogs, i can add dogs to a list of dogs, list of
    // animals but not to a list of cats
    // ie anything that is super of Dog can have dogs added to it

    // public static void addAnimals(List<? super Dog> list) {
    // list.add(new Dog());
    // }

}
