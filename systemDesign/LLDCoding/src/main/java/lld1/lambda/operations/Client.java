package lld1.lambda.operations;

public class Client {
    public static void main(String[] args) {
        // Using traditional way for addition
        MathematicalOperation addition = new AdditionOperation();
        System.out.println("Addition: " + addition.operation(5, 3));

        // Using lambda expression for addtion
        MathematicalOperation additionLambda = (a, b) -> a + b;
        System.out.println("Subtraction: " + additionLambda.operation(5, 3));

    }

}
