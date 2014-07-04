package org.intelligentjava.algos.benchmark;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.intelligentjava.algos.sort.Sorter;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * Benchmarking of various sorting algorithms.
 * 
 * @author Ignas Lelys
 * @created Jun 29, 2014
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 3, time = 1)
@State(Scope.Thread)
public class SortingBenchmark {

    private int length = 100000;

    private Distribution distribution = Distribution.RANDOM;

    private int[] array = distribution.create(length);
    
    int i = 1;

    public enum Distribution {
        SAWTOOTH {
            @Override
            int[] create(int length) {
                int[] result = new int[length];
                for (int i = 0; i < length; i += 5) {
                    result[i] = 0;
                    result[i + 1] = 1;
                    result[i + 2] = 2;
                    result[i + 3] = 3;
                    result[i + 4] = 4;
                }
                return result;
            }
        },
        INCREASING {
            @Override
            int[] create(int length) {
                int[] result = new int[length];
                for (int i = 0; i < length; i++) {
                    result[i] = i;
                }
                return result;
            }
        },
        DECREASING {
            @Override
            int[] create(int length) {
                int[] result = new int[length];
                for (int i = 0; i < length; i++) {
                    result[i] = length - i;
                }
                return result;
            }
        },
        RANDOM {
            @Override
            int[] create(int length) {
                Random random = new Random();
                int[] result = new int[length];
                for (int i = 0; i < length; i++) {
                    result[i] = random.nextInt();
                }
                return result;
            }
        };

        abstract int[] create(int length);
    }

    @Benchmark
    public int timeHeapSort() {
        int[] copy = Arrays.copyOf(array, array.length);
        int[] sorted = Sorter.heapSort(copy);
        return sorted[i];
    }

    @Benchmark
    public int timeMergeSort() {
        int[] copy = Arrays.copyOf(array, array.length);
        int[] sorted = Sorter.mergeSort(copy);
        return sorted[i];
    }

    @Benchmark
    public int timeQuickSort() {
        int[] copy = Arrays.copyOf(array, array.length);
        int[] sorted = Sorter.quickSort(copy);
        return sorted[i];
    }

    @Benchmark
    public int timeInsertionSort() {
        int[] copy = Arrays.copyOf(array, array.length);
        int[] sorted = Sorter.insertionSort(copy);
        return sorted[i];
    }

    @Benchmark
    public int timeJDKSort() {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy[i];
    }
    
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(".*" + SortingBenchmark.class.getSimpleName() + ".*").forks(1)
                .build();

        new Runner(opt).run();
    }
    
}
