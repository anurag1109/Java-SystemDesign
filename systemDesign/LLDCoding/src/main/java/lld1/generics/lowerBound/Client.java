package lld1.generics.lowerBound;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        Triplet<String> stringTriplet = new Triplet<>("A", "B", "C");
        System.out.println(
                stringTriplet.getFirst() + "---" + stringTriplet.getSecond() + "---" + stringTriplet.getThird());

        Triplet<Integer> integerTriplet = new Triplet<>(1, 2, 3);
        System.out.println(integerTriplet.getFirst() + "---" + integerTriplet.getSecond() + "---"
                + integerTriplet.getThird());

        // list of triplets
        List<Triplet<String>> listString = List.of(stringTriplet, stringTriplet);
        List<Triplet<Integer>> listInteger = List.of(integerTriplet, integerTriplet);
        printString(listString);
        printInteger(listInteger);

        // generic method
        printAny(listString);
        printAny(listInteger);

        // avg of triplets
        double nonGenericAVG = nonGenericAVG(integerTriplet);
        System.out.println("Avg: " + nonGenericAVG);
        double genericAVG = genericAVG(integerTriplet);
        System.out.println("Avg: " + genericAVG);
        double upperBoundAVG = upperBoundAVG(integerTriplet);
        System.out.println("Avg: " + upperBoundAVG);
    }

    // non-generic methods
    public static void printString(List<Triplet<String>> triplets) {
        for (Triplet<String> triplet : triplets) {
            System.out.println(triplet.getFirst() + "---" + triplet.getSecond() + "---" + triplet.getThird());
        }
    }

    // non-generic methods
    public static void printInteger(List<Triplet<Integer>> triplets) {
        for (Triplet<Integer> triplet : triplets) {
            System.out.println(triplet.getFirst() + "---" + triplet.getSecond() + "---" + triplet.getThird());
        }
    }

    // generic method
    public static <TYPE> void printAny(List<Triplet<TYPE>> triplets) {
        for (Triplet<TYPE> triplet : triplets) {
            System.out.println(triplet.getFirst() + "---" + triplet.getSecond() + "---" + triplet.getThird());

        }
    }

    // non-generic method
    public static double nonGenericAVG(Triplet<Integer> triplet) {
        int first = triplet.getFirst();
        int second = triplet.getSecond();
        int third = triplet.getThird();
        return (first + second + third) / 3;
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
}
