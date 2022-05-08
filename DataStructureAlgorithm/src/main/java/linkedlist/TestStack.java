package linkedlist;

import java.util.*;

public class TestStack {
    public static void main(String[] args) {
        int[] nums1 = {61,24,20,58,95,53,17,32,45,85,70,20,83,62,35,89,5,95,12,86,58,77,30,64,46,13,5,92,67,40,20,38,31,18,89,85,7,30,67,34,62,35,47,98,3,41,53,26,66,40,54,44,57,46,70,60,4,63,82,42,65,59,17,98,29,72,1,96,82,66,98,6,92,31,43,81,88,60,10,55,66,82,0,79,11,81};
        int[] nums2 = {5,25,4,39,57,49,93,79,7,8,49,89,2,7,73,88,45,15,34,92,84,38,85,34,16,6,99,0,2,36,68,52,73,50,77,44,61,48};
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int[] result = null;
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)){
                list1.add(num);
            }
        }
        for (int num : nums1) {
            if (set2.contains(num)){
                list2.add(num);
            }
        }
        // num1
        int[] result1 = new  int[list1.size()];
        int i = 0;
        for (Integer integer : list1) {
            result1[i]=integer;
            i++;
        }
        // num2
        int[] result2 = new  int[list2.size()];
        int j = 0;
        for (Integer integer : list2) {
            result2[j]=integer;
            j++;
        }
    }
}
