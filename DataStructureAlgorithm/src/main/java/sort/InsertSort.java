package sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort {

    public void moveInsertSort(int[] array) {
        // 逐步排序
        // 移动法
        int tmp;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            int j = i - 1;
            while (j >= 0 && tmp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j+1] = tmp;
        }
    }

    public void insertSort(int[] array) {
        // 逐步排序
        // 交换法
        int tmp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j + 1] < array[j]) {
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxSize = 100;
        int[] array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=random.nextInt(100);
        }
        // int[] array = {101, 34, 119, 1, -1, 89};
        // System.out.println(Arrays.toString(array));
        InsertSort sort = new InsertSort();
        long beforeTime = System.currentTimeMillis();
        sort.moveInsertSort(array);
        //sort.insertSort(array);
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        System.out.println(Arrays.toString(array));
        // 交换法 花费了 3.318 s!
        // 移动法 花费了 0.656 s!
    }
}