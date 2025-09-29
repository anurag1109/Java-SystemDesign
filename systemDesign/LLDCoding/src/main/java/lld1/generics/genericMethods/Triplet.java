package lld1.generics.genericMethods;

public class Triplet<TYPE> {
    TYPE first;
    TYPE second;
    TYPE third;

    public Triplet(TYPE first, TYPE second, TYPE third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public TYPE getFirst() {
        return first;
    }

    public TYPE getSecond() {
        return second;
    }

    public TYPE getThird() {
        return third;
    }

}
