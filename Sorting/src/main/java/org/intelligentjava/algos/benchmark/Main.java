package org.intelligentjava.algos.benchmark;

import org.intelligentjava.algos.benchmark.SortingBenchmark.Distribution;
import org.intelligentjava.algos.sort.Sorter;

/**
 * @author Ignas Lelys
 * @created Jul 2, 2014
 */
public class Main {
    
    private static int length = 100000;

    private static int i = 1;

    private static Distribution distribution = Distribution.RANDOM;

    public static void main(String[] args) {
        int[] data = distribution.create(length);
        long nano = System.nanoTime();
        Sorter.heapSort(data);
        System.out.println(data[0] + " " + data[i]);
        System.out.println((System.nanoTime() - nano) / 1000 + " us");
    }
}
