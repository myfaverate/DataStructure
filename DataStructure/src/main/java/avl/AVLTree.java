package avl;

public class AVLTree {
    Node root;

    // 添加节点
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空~");
        }
    }

    // 查找要删除的节点
    public Node search(int value) {
        if (root == null) {
            return null;
        } else {
            return root.search(value);
        }
    }

    // 查找要删除的节点的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(value);
        }
    }

    // 删除节点
    public void deleteNode(int value) {
        if (root == null) {
            return;
        } else {
            // 1. 需要先去找到要删除的节点
            Node targetNode = search(value);
            // 如果没有找到要删除的节点
            if (targetNode == null) {
                return;
            }
            // 如果找到的是根节点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }
            // 找targetNode的父节点
            Node parent = searchParent(value);
            // 如果要删除的节点是叶子节点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断targetNode是parent的左子节点，还是右子节点
                if (parent.left != null && parent.left == targetNode) {
                    parent.left = null;
                } else if (parent.right != null && parent.right == targetNode) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                /*   删除有两棵子树的节点
                        8 parent                    8 parent
                       /                             \
                      5 targetNode                    10 targetNode
                     / \                             /  \
                    4   6                           9    11
                */
                int minVal = deleteRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            } else {
                // 删除只有一颗子树的节点
                // 如果要删除的有左子节点
                /*
                        8 parent                    8 parent                10 parent   会出现parent空指针异常
                       /                             \                      /
                      5 targetNode                    11 targetNode        1
                     /                               /
                    4                               9
                */
                if (targetNode.left != null) {
                    if (parent != null) {
                        // 如果targetNode是parent的左子节点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        } else {
                            // targetNode是parent的右子节点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else {
                    // 如果要删除的有右子节点
                    /*   删除有两棵子树的节点
                            8 parent                         8 parent
                           /                                  \
                          5 targetNode                         12 targetNode
                           \                                    \
                            6                                    15
                    */
                    // 如果targetNode是parent的左子节点
                    if (parent != null) {
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        } else {
                            // 如果targetNode是parent的右子节点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * 1. 返回以node为根节点的二叉排序树的最小值，2. 删除以node为根节点的二叉排序树的最小节点
     *
     * @param node 传入的节点(当作二叉排序树的根节点)
     * @return 返回以node为根节点的二叉排序树的最小节点的值
     */
    public int deleteRightTreeMin(Node node) {
        Node target = node;
        // 循环遍历左子树，找到最小值
        while (target.left != null) {
            target = target.left;
        }
        deleteNode(target.value);
        return target.value;
    }

    public static void main(String[] args) {
        //int[] array = {4,3,6,5,7,8};
        //int[] array = {10, 12, 8, 9, 7, 6};
        int[] array = {10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < array.length; i++) {
            avlTree.add(new Node(array[i]));
        }
        System.out.println("中序遍历");
        avlTree.infixOrder();
//        System.out.println("没有做平衡处理器前");
//        System.out.println("树的高度"+avlTree.root.height());
//        System.out.println("树的左子树的高度"+avlTree.root.left.height());
//        System.out.println("树的右子树的高度"+avlTree.root.right.height());

        // 左旋转
        //System.out.println("没有做平衡处理器前");
//        System.out.println("树的高度"+avlTree.root.height());
//        System.out.println("树的左子树的高度"+avlTree.root.left.height());
//        System.out.println("树的右子树的高度"+avlTree.root.right.height());

        //右旋转
        System.out.println("做平衡处理后~");
        System.out.println("树的高度"+avlTree.root.height());
        System.out.println("树的左子树的高度"+avlTree.root.left.height());
        System.out.println("树的右子树的高度"+avlTree.root.right.height());

        System.out.println(avlTree.root);
    }
}
