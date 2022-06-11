package edu.tyut.dynamic;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        // 背包问题
        int[] w = {1, 4, 3}; // 物品的重量
        int[] val = {1500, 3000, 2000}; // 物品的质量
        int m = 10; // 背包的容量
        int n = val.length; // 物品的个数
        // v[i,j] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int[][] v = new int[n + 1][m + 1];
        // 为了记录存放商品的情况，定义一个二维数组
        int[][] path = new int[n + 1][m + 1];
        for (int i = 0; i < v.length; i++) {
            v[i][0]=0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i]=0;
        }

        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) { // 不处理第一行第一列
                // 使用动态规划公式
                if (w[i-1]>j){ // 如果物品重量达于背包重量
                    v[i][j]=v[i-1][j]; // 将这一列的上一行的值赋值给本行
                }else {
                    //v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    // 记录商品存放背包情况
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        for (int[] array : v) {
            System.out.println(Arrays.toString(array));
        }

        int i = path.length-1;
        int j = path[0].length-1;
        while (i>0&&j>0){
            if (path[i][j]==1){
                System.out.printf("第%d个商品房如发哦背包\n",i);
                j-=w[i-1];
            }
            i--;
        }
    }
}
