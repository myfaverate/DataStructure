package sort;

import java.util.Arrays;
import java.util.Random;

public class SelectSort {
    // 选择排序
    public void selectSort(int[] array){
        int tmp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i; j < array.length-1; j++) {
                if (array[i]>array[j+1]){
                    tmp=array[i];
                    array[i]=array[j+1];
                    array[j+1]=tmp;
                }
            }
            //System.out.printf("第 %d 轮排序的结果为 %s\n",i+1,Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxSize=90000;
        int[] array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=random.nextInt(1000000000);
        }
        // System.out.println("排序前前结果为："+Arrays.toString(array));
        SelectSort sort = new SelectSort();
        long beforeTime = System.currentTimeMillis();
        sort.selectSort(array);
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        // System.out.println("排序后前结果为："+Arrays.toString(array));
        // 花费了 10.477 s!
    }
}
