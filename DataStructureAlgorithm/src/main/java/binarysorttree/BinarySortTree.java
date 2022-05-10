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

    // 查找要删除的节点
    public Node search(int value){
        if (root==null){
            return null;
        }else {
            return root.search(value);
        }
    }

    // 查找要删除的节点的父节点
    public Node searchParent(int value){
        if (root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }

    // 删除节点
    public void deleteNode(int value){
        if (root==null){
            return;
        }else {
            // 1. 需要先去找到要删除的节点
            Node targetNode = search(value);
            // 如果没有找到要删除的节点
            if (targetNode==null){
                return;
            }
            // 如果找到的是根节点
            if (root.left==null&&root.right==null){
                root=null;
                return;
            }
            // 找targetNode的父节点
            Node parent = searchParent(value);
            // 如果要删除的节点是叶子节点
            if (targetNode.left==null&&targetNode.right==null){
                // 判断targetNode是parent的左子节点，还是右子节点
                if (parent.left!=null&&parent.left==targetNode){
                    parent.left=null;
                }else if (parent.right!=null&&parent.right==targetNode){
                    parent.right=null;
                }
            }else if (targetNode.left!=null&&targetNode.right!=null){
                /*   删除有两棵子树的节点
                        8 parent                    8 parent
                       /                             \
                      5 targetNode                    10 targetNode
                     / \                             /  \
                    4   6                           9    11
                */
                int minVal = deleteRightTreeMin(targetNode.right);
                targetNode.value=minVal;
            }else {
                // 删除只有一颗子树的节点
                // 如果要删除的有左子节点
                /*
                        8 parent                    8 parent
                       /                             \
                      5 targetNode                    11 targetNode
                     /                               /
                    4                               9
                */
                if (targetNode.left!=null){
                    // 如果targetNode是parent的左子节点
                    if (parent.left.value==value){
                        parent.left=targetNode.left;
                    }else {
                        // targetNode是parent的右子节点
                        parent.right=targetNode.left;
                    }
                }else {
                    // 如果要删除的有右子节点
                    /*   删除有两棵子树的节点
                            8 parent                         8 parent
                           /                                  \
                          5 targetNode                         12 targetNode
                           \                                    \
                            6                                    15
                    */
                    // 如果targetNode是parent的左子节点
                    if (parent.left.value==value){
                        parent.left=targetNode.right;
                    }else {
                        // 如果targetNode是parent的右子节点
                        parent.right=targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * 1. 返回以node为根节点的二叉排序树的最小值，2. 删除以node为根节点的二叉排序树的最小节点
     * @param node  传入的节点(当作二叉排序树的根节点)
     * @return      返回以node为根节点的二叉排序树的最小节点的值
     */
    public int deleteRightTreeMin(Node node){
        Node target = node;
        // 循环遍历左子树，找到最小值
        while (target.left!=null){
            target=target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    public static void main(String[] args) {
//        Random random = new Random();
//        int size = 10;
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            array[i] = random.nextInt(100);
//        }
        int[] array = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        // 循环添加节点到二叉排序树
        for (int i = 0; i < array.length; i++) {
            binarySortTree.add(new Node(array[i]));
        }
        // 中序遍历二叉树
        binarySortTree.infixOrder(); // 1 3 5 7 9 10 12
        System.out.println("=======================");

        // 测试删除叶子节点
        binarySortTree.deleteNode(3);
        //binarySortTree.deleteNode(12);
        binarySortTree.infixOrder();
    }
}
