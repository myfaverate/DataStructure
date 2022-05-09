package binarytree;

import sort.MergeSort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public void heapSort(int[] array){
        int tmp;
        // 将一个无需序列构建成一个堆
        for (int i = array.length/2-1; i >= 0; i--) {
            adjustHeap(array,i,array.length);
        }
        for (int j = array.length-1; j > 0; j--) {
            tmp=array[j];
            array[j]=array[0];
            array[0]=tmp;
            adjustHeap(array,0,j);
        }
    }
    /**
     * 将一个顺序二叉树调整为大顶堆
     * @param array  待调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length是在逐渐减少
     */
    public void adjustHeap(int[] array,int i, int length){
        int tmp = array[i]; // 取出当前节点的值，保存在临时变量
        // 1. k=i*2+1   k是i节点的左子节点
        for (int k = i*2+1; k < length; k=k*2+1) {
            if (k+1<length&&array[k]<array[k+1]){ // k+1表示i节点的右子节点
                k++;
            }
            if (array[k]>tmp){ // 如果子节点大于父节点的值
                array[i]=array[k]; // 把子节点的值赋值给父节点
                i=k;
            }else {
                break;
            }
        }
        // 将tmp的值放在调整后的位置
        array[i]=tmp;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxSize = 8000000;
        int[] array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=random.nextInt(1000000000);
        }
        //int[] array = {4,6,8,5,9,-11,90,55,22};
        //System.out.println(Arrays.toString(array));
        HeapSort sort = new HeapSort();
        long beforeTime = System.currentTimeMillis();
        sort.heapSort(array);
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        //System.out.println(Arrays.toString(array));
        // 花费了 1.688 s!
    }
}
