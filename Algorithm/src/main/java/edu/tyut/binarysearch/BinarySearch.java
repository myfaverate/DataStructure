package edu.tyut.binarysearch;

public class BinarySearch {
    // 二分查找
    public int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length-1;
        int middle=0;
        while (left<=right){
            middle = left + ((right-left)>>1);
            if (array[middle]==target){
                return middle;
            }else if (array[middle]>target){
                right = middle-1;
            }else {
                left = middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1,3,8,10,11,67,100};
        System.out.println(binarySearch.binarySearch(array,68));
    }
}
