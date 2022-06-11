package search;

import java.util.Arrays;

public class InsertValueSearch {
    /**
     * 说明：插值查找算法，要求数组是有序的
     * @param array
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public int insertValueSearch(int[] array, int left, int right, int findValue){
        // findValue<array[0]||findValue>array[array.length-1] 必须需要这两个值
        if (left>right||findValue<array[0]||findValue>array[array.length-1]){
            return -1;
        }
        // 求出middle
        int middle = left + (right-left) * (findValue-array[left]) / (array[right]-array[left]);
        int middleValue = array[middle];
        if (findValue>middleValue){ // 右递归
            return insertValueSearch(array,middle+1,right,findValue);
        }else if (findValue<middleValue){ // 左递归
            return insertValueSearch(array,left,middle-1,findValue);
        }else return middle;
    }

    public static void main(String[] args) {
        int maxSize = 100;
        int[] array = new int[maxSize];
        for (int i=0;i<array.length;i++){
            array[i]=i+1;
        }
        InsertValueSearch search = new InsertValueSearch();
        System.out.println(search.insertValueSearch(array, 0, array.length - 1, 99));
        System.out.println(Arrays.toString(array));
    }
}
