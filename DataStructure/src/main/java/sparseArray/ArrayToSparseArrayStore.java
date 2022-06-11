package sparseArray;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToSparseArrayStore {
    public static void main(String[] args) throws IOException {
        // 1. 11*11的原始棋盘，0为无效数据，1为黑子，2为白子
        int[][] chessArr = new int[15][15];
        // 2. 设置原始棋盘的有效棋子位置
        chessArr[1][1] = 1;
        chessArr[2][2] = 2;
        chessArr[3][3] = 3;
        chessArr[4][4] = 4;
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

        // 6. 将稀疏数组写入到磁盘
        // 获取文件对象
        File file = new File("D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\chess.txt");
        // 文件写入流
        FileWriter writer = new FileWriter(file);
        // 遍历数组写入文件
        for (int i = 0; i < sparseArr.length; i++) {
            if (i!=(sparseArr.length-1)){
                writer.write(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2] + "\n");
            }else {
                writer.write(sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2]);
            }
        }
        writer.close();

        // 7. 还原原始数组
        // 从磁盘中读取数据
        //File file = new File("D:\\SoftWare\\JetBrains\\Idea\\IdeaProject\\JavaMavenProject\\DataStructure\\src\\main\\resources\\chess.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        List<String> list = new ArrayList<>();
        while ((line = reader.readLine())!=null){
            list.add(line);
        }
        reader.close();
        int[][] sparseArr2 = new int[list.size()][3];
        int num = 0;
        for (String s : list) {
            String[] splits = s.split("\t");
            sparseArr2[num][0] = Integer.valueOf(splits[0]);
            sparseArr2[num][1] = Integer.valueOf(splits[1]);
            sparseArr2[num][2] = Integer.valueOf(splits[2]);
            num++;
        }

        System.out.println("读取后的稀疏数组=>");
        for (int[] arr : sparseArr2) {
            System.out.println(Arrays.toString(arr));
        }

        int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }
        System.out.println("还原后的数组=>");
        for (int[] arr : chessArr2) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
