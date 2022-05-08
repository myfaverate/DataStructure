package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public void mergeSort(int[] array,int left, int right, int[] tmp){
        if (left<right){
            int middle=(left+right)>>1;
            mergeSort(array,left,middle,tmp);
            mergeSort(array,middle+1,right,tmp);
            merge(array,left,right,middle,tmp);
        }
    }
    /**
     * 治：合并的方法
     * @param array   排序的原始数组
     * @param left    左边有序序列的初始索引
     * @param middle  中间索引
     * @param right   右边索引
     * @param tmp     做中转的数组
     */
    public void merge(int[] array,int left, int right,int middle,int[] tmp){
        int i = left; // 初始化i，左边有序序列的初始索引
        int j = middle+1; // 初始化j，右边有序序列的初始索引
        int t = 0; // 指向tmp数组的当前索引
        // 一、
        // 先把左右两边的(有序)数组按照规则填充到tmp数组
        // 直到左右两边的有序序列，有一边处理完毕即可
        while (i<=middle&&j<=right){
            if (array[i]<=array[j]){
                tmp[t]=array[i];
                t++;
                i++;
            }else {
                tmp[t]=array[j];
                t++;
                j++;
            }
        }
        // 二、
        // 把有剩余数据的一边的数据一次全部填充到tmp
        while(i<=middle){
            // 左边的有序序列还有剩余的元素，就全部填充到tmp
            tmp[t]=array[i];
            t++;
            i++;
        }
        while(j<=right){
            // 右边边的有序序列还有剩余的元素，就全部填充到tmp
            tmp[t]=array[j];
            t++;
            j++;
        }
        // 三、
        // 将tmp数组的元素拷贝到array
        t=0;
        int tmpLeft = left;
        while (tmpLeft<=right){
            array[tmpLeft]=tmp[t];
            t++;
            tmpLeft++;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int maxSize = 8000000;
        int[] array = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            array[i]=random.nextInt(1000000000);
        }
        //int[] array = {8,4,5,7,1,3,6,2};
        int[] tmp = new int[maxSize];
        //System.out.println(Arrays.toString(array));
        MergeSort sort = new MergeSort();
        long beforeTime = System.currentTimeMillis();
        sort.mergeSort(array,0, array.length -1,tmp); // 花费了 0.593 s!
        long afterTime = System.currentTimeMillis();
        System.out.println("花费了 " + (afterTime - beforeTime) / 1000.0 + " s!");
        //System.out.println(Arrays.toString(array));
    }
}
