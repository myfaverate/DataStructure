package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public void bubbleSort(int[] array) {
        int tmp;
        boolean flag = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false; // 重置flag
            }
            //System.out.printf("第%d排序后: %s\n",i+1,Arrays.toString(array));
        }
        //System.out.println("排序后: "+Arrays.toString(array));
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 90000;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000000);
        }
        // 时间复杂度O(n²)
        //System.out.println("排序前: "+Arrays.toString(array));
        BubbleSort sort = new BubbleSort();
        long beforeTime = System.currentTimeMillis();
        sort.bubbleSort(array);
        //System.out.println("排序后: "+Arrays.toString(array));
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        // 花费了 8.788 s!
    }
}
