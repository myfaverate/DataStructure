package sparseArray;

import java.util.Arrays;

public class SparseArray {
    public static void main(String[] args) {
        // 1. 11*11的原始棋盘，0为无效数据，1为黑子，2为白子
        int[][] chessArr = new int[12][12];
        // 2. 设置原始棋盘的有效棋子位置
        chessArr[1][1] = 1;
        chessArr[2][2] = 2;
        chessArr[3][3] = 3;
        System.out.println("原始数组=>");
        for (int[] arr : chessArr) {
            System.out.println(Arrays.toString(arr));
        }
        // 3. 获取有效值的个数
        int sum = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j]!=0){
                    sum++;
                }
            }
        }
        // 4. 初始化稀疏数组 有效数个数+1 行 ， 3列
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = chessArr.length;
        sparseArr[0][1] = chessArr[0].length;
        sparseArr[0][2] = sum;
        // 5. 将有效值装入稀疏数组
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[0].length; j++) {
                if (chessArr[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("稀疏数组=>");
        for (int[] arr : sparseArr) {
            System.out.println(Arrays.toString(arr));
        }
        // 6. 还原原始数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("还原后的数组=>");
        for (int[] arr : chessArr2) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
