package edu.tyut.leetcodesimple;

public class ANumberAppearsOnlyOnce {
    // 神评：看见你的代码瞬间感觉自己是个废物
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[0] = nums[0]^nums[i];
        }
        return nums[0];
    }
}
