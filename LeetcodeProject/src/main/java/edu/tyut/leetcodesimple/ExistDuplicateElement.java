package edu.tyut.leetcodesimple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExistDuplicateElement {
    public boolean containsDuplicate(int[] nums) {
        // 1. 暴力求解， 会超时
//        boolean flag = false;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i + 1]) return !flag;
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return !flag;
//                }
//            }
//        }
//        return flag;
        // 2. 先排序，后求解
//        Arrays.sort(nums);
//        boolean flag = false;
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i] == nums[i + 1]) {
//                flag = !flag;
//                break;
//            }
//        }
//        return flag;
        // 3. 使用set集合，添加元素时，出现重复元素。之前的元素会被覆盖，并返回false
        Set<Integer> set = new HashSet<Integer>();
        boolean flag = false;
        for (int num : nums) {
            if (!set.add(num)) {
                flag = true;
                break;
            } else flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        ExistDuplicateElement element = new ExistDuplicateElement();
        int[] nums = {1, 1, 2, 3, 4};
        System.out.println(element.containsDuplicate(nums));
    }
}
