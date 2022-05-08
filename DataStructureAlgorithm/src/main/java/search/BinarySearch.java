package search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    /**
     * 二分递归查找算法, 无法找到重复值
     *
     * @param array     数组
     * @param left      左边的索引
     * @param right     右边的索引
     * @param findValue 要查找的值
     * @return 找到返回下标，没找到返回-1
     */
    public int binarySearch(int[] array, int left, int right, int findValue) {
        if (left > right) return -1;
        int middle = (left + right) >> 1;
        int middleValue = array[middle];
        if (findValue > middleValue) {
            return binarySearch(array, middle + 1, right, findValue);
        } else if (findValue < middleValue) {
            return binarySearch(array, left, middle - 1, findValue);
        } else return middle;
    }

    public List binarySearchList(int[] array, int left, int right, int findValue) {
        List<Integer> list = new ArrayList<>();
        if (left > right) {
            return list;
        }
        int middle = (left + right) >> 1;
        int middleValue = array[middle];
        int tmp = 0;
        if (findValue > middleValue) {
            return binarySearchList(array, middle + 1, right, findValue);
        } else if (findValue < middleValue) {
            return binarySearchList(array, left, middle - 1, findValue);
        } else {
            list.add(middle);
            tmp=middle;
            while (tmp < array.length - 1 && array[tmp+1] == findValue) {
                list.add(++tmp);
            }
            tmp=middle;
            while (tmp > 0 && array[tmp-1] == findValue) {
                list.add(--tmp);
            }
            return list;
        }
    }

    public static void main(String[] args) {
        int[] array = {90, 90, 91, 92, 94, 99, 99, 99};
        BinarySearch search = new BinarySearch();
        //System.out.println(search.binarySearch(array, 0, array.length - 1, 90));
        System.out.println(search.binarySearchList(array, 0, array.length - 1, 91));
        System.out.println((13+5)>>1);
        System.out.println(5+(13-5)>>1);
        System.out.println((5+(13-5))>>1); // +的优先级大于>>
        System.out.println((13-5)>>1);
    }
}
