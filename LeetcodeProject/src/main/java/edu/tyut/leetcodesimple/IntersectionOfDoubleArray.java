package edu.tyut.leetcodesimple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfDoubleArray {
    public static void main(String[] args) {
        int[] array1 = {2,4,6,2,4,0,3,2,1,0};
        int[] array2 = {2,5,8,5,4,1,2,9,8,4};
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i=0;
        int j=0;
        while (i< array1.length&&j< array2.length){
            if (array1[i]<array2[j]){
                i++;
            }else if (array1[i]>array2[j]){
                j++;
            }else {
                list.add(array1[i]);
                i++;
                j++;
            }
        }
        i=0;
        int[] array = new int[list.size()];
        for (Integer integer : list) {
            array[i]=integer;
            i++;
        }
        System.out.println(Arrays.toString(array));
    }
}
