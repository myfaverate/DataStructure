package edu.tyut.leetcodesimple;

import java.util.Arrays;

public class MiniOperationalStepsRestoreArrangement {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        int[] tmp = new int[n];
        int[] temp = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            tmp[i] = i;
        }
        while (true) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                }
                if (i % 2 == 1) {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            temp = perm;
            perm = arr;
            arr = temp;
            count++;
            if (Arrays.equals(tmp,perm)){
                break;
            }
            System.out.println("arr:"+Arrays.toString(arr));
            System.out.println("perm"+Arrays.toString(perm));
        }
        return count;
    }

    public static void main(String[] args) {
        MiniOperationalStepsRestoreArrangement arrangement = new MiniOperationalStepsRestoreArrangement();
        int result = arrangement.reinitializePermutation(2);
        System.out.println(result);
    }
}
