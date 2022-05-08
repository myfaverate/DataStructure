package binarytree;

public class ThreadedBinaryTree {
    public static void main(String[] args) {
        BinaryTreeTwo binaryTreeTwo = new BinaryTreeTwo();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关羽");
        HeroNode node6 = new HeroNode(6, "武松");
        HeroNode node7 = new HeroNode(7, "张顺");
        HeroNode node8 = new HeroNode(8, "李逵");
        HeroNode node9 = new HeroNode(9, "李逵");
        HeroNode node10 = new HeroNode(10, "李逵");
        HeroNode node11 = new HeroNode(11, "李逵");
        HeroNode node12 = new HeroNode(12, "李逵");
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left=node8;
        node5.left=node9;
        node9.right=node12;
        node7.left=node10;
        node7.right=node11;

        // 测试中序线索化
        binaryTreeTwo.root=root;
        //binaryTreeTwo.infixOrder();
        //binaryTreeTwo.threadedNode();
//        // 8 的后继 3
//        // 10 的前驱3 后继 1
//        // 14 的前驱1 后继 6
//        System.out.println("8 的后继: "+node4.right);
//        System.out.printf("10 的前驱 %s 后继 %s\n",node5.left,node5.right);
//        System.out.printf("14 的前驱 %s 后继 %s\n",node6.left,node6.right);

        // 中序遍历线索化二叉树
        //binaryTreeTwo.threadedList();

//        // 测试前序线索化
//        // 前序遍历线索化二叉树
        //binaryTreeTwo.preThreadedNode();
//        System.out.printf("8 的前驱 %s 后继 %s\n", node4.left, node4.right);
//        System.out.printf("10 的前驱 %s 后继 %s\n", node5.left, node5.right);
//        System.out.println("6 的前驱: " + node3.left);
//        System.out.println("14 的前驱: " + node6.left);
        //binaryTreeTwo.preOrderThreadedList();

        // 测试后序线索化
        // 后序遍历线索化二叉树

        // 测试1
//        binaryTreeTwo.postThreadedNode();
//        System.out.printf("8 的后继 %s\n",node4.right);
//        System.out.printf("10 的前驱 %s 后继 %s\n", node5.left, node5.right);
//        System.out.printf("11 的前驱 %s 后继 %s\n", node7.left, node7.right);
//        System.out.printf("6 的前驱 %s 后继 %s\n", node3.left, node3.right);
//        System.out.printf("14 的前驱 %s 后继 %s\n", node6.left, node6.right);
//        System.out.printf("15 的前驱 %s 后继 %s\n", node8.left, node8.right);
//        binaryTreeTwo.postOrderThreadedList();

        // 测试2
        //binaryTreeTwo.postOrder();
        //binaryTreeTwo.postThreadedNode();
//        System.out.printf("4 的前驱 %s 后继 %s\n", node4.left, node4.right);
//        System.out.printf("5 的前驱 %s 后继 %s\n", node5.left, node5.right);
//        System.out.printf("8 的前驱 %s 后继 %s\n", node8.left, node8.right);
//        System.out.printf("9 的前驱 %s 后继 %s\n", node9.left, node9.right);
//        System.out.printf("12 的前驱 %s 后继 %s\n", node12.left, node12.right);
//        System.out.printf("6 的前驱 %s 后继 %s\n", node6.left, node6.right);
//        System.out.printf("10 的前驱 %s 后继 %s\n", node10.left, node10.right);
//        System.out.printf("11 的前驱 %s 后继 %s\n", node11.left, node11.right);
//        binaryTreeTwo.postRecursionOrderThreadedList(root);
    }
}
