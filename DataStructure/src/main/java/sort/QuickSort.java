package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public void selfQuickSort(int left, int right, int[] array) {
        // 这种算法并不能完成排序任务
        int l = left;
        int r = right;
        int tmp;
        while (l < r) {
            if (array[l] > array[r]) {
                tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
            l++;
            r--;
        }
        if (left < r) {
            selfQuickSort(left, r, array);
        }
        if (right > l) {
            selfQuickSort(l, right, array);
        }
    }

    public void quickSort(int left, int right, int[] array) {
        // 改进
        int l = left;
        int r = right;
        int tmp = array[left];
        while (l < r) {
            while (l < r&&array[r] >= tmp) {
                r--;
            }
            array[l]=array[r];
            while (l < r&&array[l] <= tmp) {
                l++;
            }
            array[r]=array[l];
        }
        array[r]=tmp;
        l++;
        r--;
        if (left<r){
            quickSort(left,r,array);
        }
        if (right>l){
            quickSort(l,right,array);
        }
    }

    public static void guiQuickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[(left + right) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            guiQuickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            guiQuickSort(arr, l, right);
        }


    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxSize = 800000;
        int[] array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=random.nextInt(1000000000);
        }
        //int[] array = {101, 34, 119, 1, -1, 89,-2};
        //int[] array = {4, 2, 0, 1, 2, 4, 9, 7, 2, 0};
        //System.out.println(Arrays.toString(array));
        QuickSort sort = new QuickSort();
        long beforeTime = System.currentTimeMillis();
        //sort.guiQuickSort(array,0,array.length-1); // 花费了 1.047 s!
        sort.quickSort(0, array.length - 1, array); // 花费了 0.593 s!
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        System.out.println(Arrays.toString(array));
        // 花费了 0.844 s!
    }
}
