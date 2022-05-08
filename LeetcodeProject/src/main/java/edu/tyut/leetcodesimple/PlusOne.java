package edu.tyut.leetcodesimple;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] array = {6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3};
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i]!=9){
                array[i]++;
                return;
            }else {
                array[i]=0;
            }
        }
        int[] tmp = new int[array.length+1];
        tmp[0]=1;
        System.out.println(Arrays.toString(array));
    }
}
