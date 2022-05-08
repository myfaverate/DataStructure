package edu.tyut.leetcodesimple;

import java.util.Arrays;

public class DeleteDuplicate {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i += 1;
                nums[i] = nums[j];
            }
        }
        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
    }

}
