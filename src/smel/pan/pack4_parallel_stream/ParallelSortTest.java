package smel.pan.pack4_parallel_stream;import java.util.ArrayList;import java.util.List;import java.util.UUID;import java.util.concurrent.TimeUnit;/** * Created by SmelayaPanda on 21.04.2016. * * @ParallelSort Operations on sequential streams are performed on a single thread * while operations on parallel streams are performed concurrent on multiple threads. */public class ParallelSortTest {    /**     * First we create a large list of unique elements     * A class that represents an immutable universally unique identifier (UUID).     * A UUID represents a 128-bit value.     */    public static void main(String[] args) {        int max = 1000000; //million        List<String> values = new ArrayList<>(max);        for (int i = 0; i < max; i++) {            UUID uuid = UUID.randomUUID();            values.add(uuid.toString());        }        /**         * Now we measure the time it takes to sort a stream of this collection         * Sequential sort         * */        long t0 = System.nanoTime();        long count = values.stream().sorted().count();        long t1 = System.nanoTime();        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);        System.out.println(String.format                ("Sequential sort of " + count + " UUID's elements took:\n%d ms", millis)); //651        /**         * Parallel sort         * */        long tp00 = System.nanoTime();        long countP = values.parallelStream().sorted().count();        long tp11 = System.nanoTime();        long millis1 = TimeUnit.NANOSECONDS.toMillis(tp11 - tp00);        System.out.println(String.format                ("Parallel sort of " + count + " UUID's elements took:\n%d ms", millis1)); //291        /**         * As you can see both code snippet are almost identical         * but the parallel sort quickly more then two times         * */    }}