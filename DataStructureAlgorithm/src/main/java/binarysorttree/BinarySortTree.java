package binarysorttree;

import java.util.Random;

public class BinarySortTree {
    Node root;
    // 添加节点
    public void add(Node node){
        if (root==null){
            root=node;
        }else {
            root.add(node);
        }
    }
    // 中序遍历
    public void infixOrder(){
        if (root!=null){
            root.infixOrder();
        }else {
            System.out.println("二叉排序树为空~");
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        //int[] array = {7,3,10,12,5,1,9};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环添加节点到二叉排序树
        for (int i = 0; i < array.length; i++) {
            binarySortTree.add(new Node(array[i]));
        }
        // 中序遍历二叉树
        binarySortTree.infixOrder(); // 1 3 5 7 9 10 12
    }
}
