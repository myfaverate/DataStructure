package edu.tyut.leetcodesimple;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        int[] tmp = new int[nums.length];
        int index=0;
        for (int num : nums) {
            if (num!=0){
                tmp[index]=num;
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            tmp[index]=0;
            //index++;
        }
        System.out.println(Arrays.toString(tmp));
        System.arraycopy(tmp,0,nums,0,nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
