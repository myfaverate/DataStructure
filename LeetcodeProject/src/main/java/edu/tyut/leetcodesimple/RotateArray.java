package edu.tyut.leetcodesimple;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        k = k % nums.length;
        int[] array = new int[nums.length];
        System.arraycopy(nums, 0, array, 0, nums.length);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < nums.length; i++) {
            nums[(i+k)%nums.length] = array[i];
        }
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
