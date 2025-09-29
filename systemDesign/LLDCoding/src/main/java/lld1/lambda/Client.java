package lld1.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lld1.sorting.comparable.Student;

public class Client {

    public static void main(String[] args) {
        // lambda is used to provide the implementation of an interface which has
        // functional interface(only one abstract method)
        // we can use lambda expression to represent the instance of that interface

        // syntax of lambda expression
        // (argument-list) -> {body-of-lambda}

        // v1
        // example of runnable interface
        Runnable r1 = new Child();
        Thread t1 = new Thread(r1);
        t1.start();

        // v2
        // using lambda expression - no extra student class needed
        Runnable r2 = () -> {
            System.out.println("Thread is running using lambda");
        };
        Thread t2 = new Thread(r2);
        t2.start();

        // what lambda does internally is -
        // it creates an anonymous class that implements the interface we use in lambda
        // expression and copy the body of lambda expression to the only abstract method
        // of that
        // interface.(in this case run() method of Runnable interface)

        // since lambda expression can only be used with functional interface ie
        // interface with
        // only one abstract method, we can also use it with comparator interface

    }
}
