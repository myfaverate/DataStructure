package edu.tyut.leetcodesimple;

public class BinarySearch {
    public int search(int[] nums, int target) {
        // 非递归，前期数组必须有序
        // 提前筛选
        if (target < nums[0] || target > nums[nums.length - 1]){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) >> 1;
            if (nums[middle] == target){
                return middle;
            }else if (nums[middle] < target) {
                // 防止死循环
                left = middle+1;
                //left = middle;
            } else if (nums[middle] > target) {
                right = middle-1;
                //right = middle;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
                    // 0  1  2  3  4  5   6
        int[] nums = {-1,-1, 0, 2, 3, 3, 3, 5, 9, 12};
        int target = -1;
        BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search(nums, target);
        System.out.println(search);

    }
}
