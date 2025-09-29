package lld1.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MyStream<T> {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 3, 4));

        //
        Stream<Integer> s1 = list.stream();// now act as stream
        s1.forEach((elem) -> System.out.println(elem));

        // looping on stream again will show erroe as stream can be accessed only once
        // Exception in thread "main" java.lang.IllegalStateException: stream has
        // already been operated upon or closed

        // s1.forEach((elem) -> System.out.println(elem));
        // this foreact is a functional interface, accept one argument
    }
}