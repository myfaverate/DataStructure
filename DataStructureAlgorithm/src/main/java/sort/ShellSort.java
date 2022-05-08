package sort;

import java.util.Arrays;
import java.util.Random;

public class ShellSort {
    // 希尔排序，增强版插入排序
    public void shellSort(int[] array) {
        // Changed Method
        // 第一轮希尔排序
        int tmp;
        for (int gap=array.length; gap > 0; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        tmp=array[j];
                        array[j]=array[j+gap];
                        array[j+gap]=tmp;
                    }
                }
            }
        }
    }
    public void moveShellSort(int[] array) {
        // Changed Method
        // 第一轮希尔排序
        int tmp;
        for (int gap=array.length; gap > 0; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                tmp = array[i];
                int j = i - gap;
                while (j >= 0 && tmp < array[j]) {
                    array[j+gap] = array[j];
                    j -= gap;
                }
                array[j+gap] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int maxSize=80000;
        int[] array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=random.nextInt(1000000000);
        }
        //int[] array = {8,9,1,7,2,3,5,4,6,0};
        //System.out.println("排序前前结果为："+ Arrays.toString(array));
        ShellSort sort = new ShellSort();
        long beforeTime = System.currentTimeMillis();
        //sort.shellSort(array);
        sort.moveShellSort(array);
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        //System.out.println("排序后前结果为："+Arrays.toString(array));
        //交换法 花费了 4.829 s!
        //移动法 花费了 0.015 s!
    }
}
