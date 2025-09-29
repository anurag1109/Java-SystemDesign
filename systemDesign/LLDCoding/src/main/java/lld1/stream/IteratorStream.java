package lld1.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorStream {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 2, 3, 4));

        // Iterator has hasNext() and next() methods, but to use them we need to
        // obtain an iterator from the list using listIterator() or iterator().
        Iterator<Integer> iterator = list.listIterator();

        while (iterator.hasNext())
            System.out.println(iterator.next());

        // Reduce return only single value
        Stream<Integer> str = list.stream();
        str.reduce(0, (acc, cur) -> {
            return acc + cur;
        });
    }

}
