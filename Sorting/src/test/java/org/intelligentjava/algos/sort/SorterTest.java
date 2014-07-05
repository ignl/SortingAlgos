package org.intelligentjava.algos.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for sorting algorithms.
 * 
 * @author Ignas Lelys
 * @created Apr 18, 2011
 * 
 */
public class SorterTest {

    @Test
    public void testBucketSortSimple() {
        double[] data = { 0.111, 0.652, 0.744, 0.199, 0.222, 0.366, 0.998, 0.145, 0.133, 0.180, 0.763, 0.163, 0.965,
                0.111, 0.512 };
        double[] result = Sorter.bucketSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 15);
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testRadixSortSimple() {
        int[] data = { 100, 152, 144, 199, 100, 166, 198, 145, 133, 180, 163, 163, 165, 111, 112 };
        int[] result = Sorter.radixSort(data, 3);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 15);
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testCountingSortSimple() {
        int[] data = { 100, 52, 44, 99, 100, 66, 98, 45, 33, 180, 63, 63, 65, 1, 2 };
        int[] result = Sorter.countingSort(data, 180);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 15);
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testHeapSortSimple() {
        int[] data = { 100, 52, 44, 99, 100, 66, 98, 45, 33, 180, 63, 63, 65, 1, 2 };
        int[] result = Sorter.heapSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 15);
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testHeapSortEmptyArray() {
        int[] data = {};
        int[] result = Sorter.heapSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 0);
    }

    @Test
    public void testHeapSortOneElement() {
        int[] data = { 0 };
        int[] result = Sorter.heapSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 1);
        Assert.assertTrue(result[0] == 0);
    }

    @Test
    public void testInsertionSortSimple() {
        int[] data = { 100, 52, 44, 99, 100, 66, 98, 45, 33, 180, 63, 63, 65, 1, 2 };
        int[] result = Sorter.insertionSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 15);
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testMergeSortSimple() {
        int[] data = { 100, 52, 44, 99, 100, 66, 98, 45, 33, 180, 63, 63, 65, 1, 2 };
        int[] result = Sorter.mergeSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 15);
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] data = {};
        int[] result = Sorter.mergeSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 0);
    }

    @Test
    public void testMergeSortOneElement() {
        int[] data = { 0 };
        int[] result = Sorter.mergeSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 1);
        Assert.assertTrue(result[0] == 0);
    }

    @Test
    public void testQuickSortSimple() {
        int[] data = { 100, 52, 44, 99, 100, 66, 98, 45, 33, 180, 63, 63, 65, 1, 2 };
        int[] result = Sorter.quickSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 15);
        for (int i = 0; i < data.length - 1; i++) {
            Assert.assertTrue(result[i] <= result[i + 1]);
        }
    }

    @Test
    public void testQuickSortEmptyArray() {
        int[] data = {};
        int[] result = Sorter.quickSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 0);
    }

    @Test
    public void testQuickSortOneElement() {
        int[] data = { 0 };
        int[] result = Sorter.quickSort(data);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.length == 1);
        Assert.assertTrue(result[0] == 0);
    }
}
