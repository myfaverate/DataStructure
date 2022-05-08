package edu.tyut.leetcodesimple;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralMatrix(int[][] matrix){
        int level_start = 0;
        int level_end = matrix[0].length-1;
        int high_start = 0;
        int high_end = matrix.length-1;
        int target = matrix.length*matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        // 1 2 3
        // 4 5 6
        // 7 8 9
        while (true){
            for (int i=level_start;i<=level_end;i++){
                result.add(matrix[high_start][i]);
            }
            high_start++;
            if (result.size()>=target){
                break;
            }
            for (int i=high_start;i<=high_end;i++){
                result.add(matrix[i][level_end]);
            }
            level_end--;
            if (result.size()>=target){
                break;
            }
            for (int i=level_end;i>=level_start;i--){
                result.add(matrix[high_end][i]);
            }
            high_end--;
            if (result.size()>=target){
                break;
            }
            for (int i=high_end;i>=high_start;i--){
                result.add(matrix[i][level_start]);
            }
            level_start++;
            if (result.size()>=target){
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        // 1   2   3   4
        // 5   6   7   8
        // 9   10  11  12
        // 13  14  15  16
        //1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
        int[][] my_matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(matrix.spiralMatrix(my_matrix));
    }
}
