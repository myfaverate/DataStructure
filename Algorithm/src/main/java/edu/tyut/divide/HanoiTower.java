package edu.tyut.divide;

public class HanoiTower {
    /**
     * 移汉诺塔问题 A-C
     * 分：将所有盘看成看两个盘：最下面的盘和其上面的所有盘
     * @param num   圆盘个数
     * @param a     塔A
     * @param b     塔B
     * @param c     塔C
     */
    public void hanoiTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println("第1个盘从 "+a+"->"+c);
        }else {
            // 如果有两个及以上的圆盘，我们总是可以看作是两个盘1，最下面的一个盘2，上面的所有盘
            // 1. 先把最上面的所有盘A-B, 移动过程会使用到C
            hanoiTower(num-1,a,c,b);
            // 2. 把最下面的盘从A->C
            System.out.println("第"+num+"个盘从 "+a+"->"+c);
            // 3. 把B塔的所有盘从B-C，移动过程使用到A塔
            hanoiTower(num-1,b,a,c);
        }
    }

    public static void main(String[] args) {
        HanoiTower tower = new HanoiTower();
        tower.hanoiTower(6,'A','B','C');
    }
}
    /*
        分治算法应用：
        傅里叶变换 (快速傅里叶变换)
        二分搜索
        大整数乘法
        棋盘覆盖
        合并排序
        快速排序
        线性时间选择
        最接近点对问题
        循环赛日程表
        汉诺塔
     */