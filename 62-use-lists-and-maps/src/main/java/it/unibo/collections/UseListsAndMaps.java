package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    final static Integer MIN_VALUE = 1000;
    final static Integer MAX_VALUE = 2000;

    final static Long ELEMS = 100_000L;
    final static Long READ_COUNT = 1_000L;


    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> list = new ArrayList<>();
        for (var i = MIN_VALUE; i <= MAX_VALUE; i++) {
            list.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linkedList = new LinkedList<>(list);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        var tempInteger = list.getFirst();
        list.set(list.size() - list.size(), list.getLast());
        list.set(list.size() - 1, tempInteger);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (var element : list) {
            IO.print(element + " ");
        }
        IO.println();

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        testWritePerformance(ELEMS, list);
        testWritePerformance(ELEMS, linkedList);
        

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        testReadPerformance(list.size() / 2, READ_COUNT, list);
        testReadPerformance(linkedList.size() / 2, READ_COUNT, linkedList);

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> countries = new HashMap<>();
        countries.put("Africa", 1_110_635_000L);
        countries.put("Americas", 972_005_000L);
        countries.put("Antarctica", 0L);
        countries.put("Asia", 4_298_723_000L);
        countries.put("Europe", 742_452_000L);
        countries.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */
        Long population = 0L;
        for (var value : countries.values()) {
            Long.sum(population, value);
        }
        IO.println("population:" + population);
    }

    private static void testWritePerformance(Long elementsConunt, List<Integer> list) {
        long time = System.nanoTime();
        for (var i = 0; i < elementsConunt; i++) {
            list.set(0, i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Time spend to add " + elementsConunt + " elements to the list: " + millis + "ms");
    }

    private static void testReadPerformance(Integer index, Long operationsCount, List<Integer> list) {
        long time = System.nanoTime();
        for (var i = 0; i < operationsCount; i++) {
            list.get(index);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Time spend to read " + operationsCount + " times ad a list element: " + millis + "ms" + "or " + time + "ns");
    }
}
