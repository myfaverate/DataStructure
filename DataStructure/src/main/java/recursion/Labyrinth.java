package recursion;

import java.util.Arrays;

// 迷宫问题
public class Labyrinth {
    public static void main(String[] args) {
        // 先创建一个二维数组，来模拟迷宫
        // 定义一个地图
        int[][] map = new int[15][14];
        // 使用1表示墙
        // 左右全部置为1
        for (int i = 0; i < map.length; i++) {
            map[i][0]=1;
            map[i][map[0].length-1]=1;
        }
        // 上下全部置为1
        for (int i = 0; i < map[0].length; i++) {
            map[0][i]=1;
            map[map.length-1][i]=1;
        }
        // 设置挡板 这里有点小问题
        for (int i = 0; i < map[0].length-2; i++) {
            map[3][i]=1;
        }
        for (int i = map[0].length-1; i > 3; i--) {
            map[map.length-4][i]=1;
        }
        // 打印
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
        System.out.println("=====================================");
        // 迷宫回溯测试
        Labyrinth labyrinth = new Labyrinth();
        labyrinth.setWay(map,1,1);
        for (int[] m : map) {
            System.out.println(Arrays.toString(m));
        }
    }

    /**
     * 使用递归回溯算法来给小球找路
     * 说明：
     * 1. map 表示地图
     * 2. i，j 表示从地图的哪个位置开始出发(1,1)
     * 3. 如果小球能到map[map.length-2][map[0].length-2]位置，则说明通路找到
     * 4. 约定：当map[i][j]为0表示该点没有走过，当为1表示墙；2表示通路可以走；3表示该点已经走过，但走不通
     * 5. 走迷宫时的一个策略 下 右 上 左，如果该点走不通，在回溯
     * @param map 表示地图
     * @param i   表示从哪个位置开始
     * @param j
     * @return    如果找到通路就返回true，否则返回false
     */
    public boolean setWay(int[][] map, int i, int j){
        if (map[map.length-2][map[0].length-2]==2){
            return true;
        }else {
            if (map[i][j]==0){
                // 如果当前这个点还没有走过
                // 按照策略 下 右 上 左 走
                map[i][j]=2; // 假定该点可以走通
                if (setWay(map, i+1, j)){ // 向下走
                    return true;
                }else if (setWay(map, i, j+1)){ // 向右走
                    return true;
                }else if (setWay(map, i, j-1)){ // 向左走
                    return true;
                }else if (setWay(map, i-1, j)){ // 向上走
                    return true;
                }else {
                    // 说明该点是走不通的是死路
                    map[i][j]=3;
                    return false;
                }
            }else {
                // 如果map[i][j]！=0，可能是1，2，3
                return false;
            }
        }
    }
}
