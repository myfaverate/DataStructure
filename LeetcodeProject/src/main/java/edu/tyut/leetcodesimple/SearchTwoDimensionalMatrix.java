package edu.tyut.leetcodesimple;

public class SearchTwoDimensionalMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columnMax = matrix[0].length;
        int rowMax = matrix.length;
        if (target < matrix[0][0] || target > matrix[rowMax - 1][columnMax - 1]) {
            return false;
        }
        // 对每一行使用二分查找
        for (int i = 0; i < rowMax; i++) {
            int left = 0;
            int right = columnMax - 1;
            while (left <= right) {
                int middle = (right + left) >> 1;
                if (target == matrix[i][middle]) {
                    return true;
                } else if (target > matrix[i][middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchTwoDimensionalMatrix searchTwoMatrix = new SearchTwoDimensionalMatrix();
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 16}};
        int target = 16;
        System.out.println(searchTwoMatrix.searchMatrix(matrix, target));
    }

}
