package sort;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    // 基数排序
    public void radixSort(int[] array) {
        // 1. 得到数组中最大的数的位数
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // 2. 得到的最大数是几位数
        int maxLength = String.valueOf(max).length();
        // 3. 初始化桶
        int[][] bucket = new int[10][array.length];
        int[] bucketElementCounts = new int[10];
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < array.length; j++) {
                // 取出每个元素对应的位数的值
                int digitElement = array[j] / ((int) Math.pow(10, i)) % 10;
                // 放入对应的桶中
                bucket[digitElement][bucketElementCounts[digitElement]] = array[j];
                bucketElementCounts[digitElement]++;
            }
            // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
            int index = 0;
            // 遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < 10; k++) {
                // 如果桶中有数据，我们放入到原数组
                if (bucketElementCounts[k] != 0) {
                    // 循环取出桶中数据，放入原数组
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        array[index++] = bucket[k][j];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxSize = 80000;
        // OutOfMemoryError
        int[] array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=random.nextInt(1000000000);
        }
        //int[] array = {101, 34, 119, 1, 1, 89, 2};
        //int[] array = {4, 2, 0, 1, 2, 4, 9, 7, 2, 0};
        //System.out.println(Arrays.toString(array));
        RadixSort sort = new RadixSort();
        long beforeTime = System.currentTimeMillis();
        sort.radixSort(array);
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        //System.out.println(Arrays.toString(array));
        // 花费了 0.844 s!
    }
}
