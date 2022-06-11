package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree {
    public TreeNode build(){
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        TreeNode nodeG = new TreeNode('G');
        TreeNode nodeH = new TreeNode('H');
        nodeA.left=nodeB;
        nodeA.right=nodeC;
        nodeB.left=nodeD;
        nodeB.right=nodeE;
        nodeC.left=nodeF;
        nodeC.right=nodeG;
        nodeE.right=nodeH;
        return nodeA;
    }
    // 前序遍历 递归
    public void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }
    // 前序遍历 迭代
    public void preOrderNonRecursion(TreeNode root){
        if (root==null){
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.pop();
            System.out.println(cur.toString());
            if (cur.right!=null){
                queue.push(cur.right);
            }
            if (cur.left!=null){
                queue.push(cur.left);
            }
        }
    }

    // 中序遍历 递归
    public void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root);
        inOrder(root.right);
    }
    // 中序遍历 递归
    public void postOrder(TreeNode root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.build();
        //binaryTree.preOrder(root);
        //binaryTree.preOrderNonRecursion(root);
        //binaryTree.inOrder(root);
        binaryTree.postOrder(root);
    }
}