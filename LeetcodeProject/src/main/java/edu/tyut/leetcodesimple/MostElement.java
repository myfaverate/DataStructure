package edu.tyut.leetcodesimple;

import java.util.Arrays;

public class MostElement {
    public static void main(String[] args) {
        int[] nums = {6,5,5};
        int tmp;
        // 这不是冒泡排序
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length-1;j++){
                if(nums[i]>nums[j+1]){
                    tmp=nums[i];
                    nums[i]=nums[j+1];
                    nums[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
