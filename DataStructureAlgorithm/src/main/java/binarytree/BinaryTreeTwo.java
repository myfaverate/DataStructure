package binarytree;


public class BinaryTreeTwo {
    public HeroNode root;
    public HeroNode preNode; // node节点的前驱节点

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空无法遍历！");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空无法遍历！");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空无法遍历！");
        }
    }

    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    // 后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    // 删除节点
    public void deleteNode(int no) {
        if (root != null) {
            if (root.no == no) {
                root = null;
            } else {
                root.deleteNode(no);
            }
        } else {
            System.out.println("空树不能删除！");
        }
    }

    /**
     * 编写对二叉树进行中序线索化的方法
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNode(HeroNode node) {
        if (node == null) {
            return;
        }
        // 1. 先线索化左子树
        threadedNode(node.left);
        // 2. 线索化当前节点
        // (1) 处理当前节点的前驱节点
        if (node.left == null) {
            // 让当前节点的左指针指向前驱节点
            node.left = preNode;
            node.leftType = 1;
        }
        // (2) 处理当前节点的后继节点
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.rightType = 1;
        }
        // !!! 没处理一个节点后，让当前节点是下一个节点的前驱节点
        preNode = node;
        // 3. 先线索化右子树
        threadedNode(node.right);
    }

    //重载
    public void threadedNode() {
        this.threadedNode(root);
    }

    // 中序遍历线索二叉树
    public void threadedList() {
        HeroNode node = root;
        while (node != null) {
            // 循环找leftType==1的节点
            while (node.leftType == 0) {
                node = node.left;
            }
            System.out.println(node);
            while (node.rightType == 1) {
                node = node.right;
                System.out.println(node);
            }
            node = node.right;
        }
    }

    /**
     * 编写对二叉树进行前序序线索化的方法
     * 1 3 8 10 6 14
     *
     * @param node 当前需要线索化的节点
     */
    public void preThreadedNode(HeroNode node) {
        if (node == null) {
            return;
        }
        // 1. 线索化当前节点
        // (1) 处理当前节点的前驱节点
        if (node.left == null) {
            // 让当前节点的左指针指向前驱节点
            node.left = preNode;
            node.leftType = 1;
        }
        // (2) 处理当前节点的后继节点
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.rightType = 1;
        }
        // !!! 没处理一个节点后，让当前节点是下一个节点的前驱节点
        preNode = node;
        // 2. 先线索化左子树
        if (node.leftType != 1) {
            preThreadedNode(node.left);
        }
        // 3. 先线索化右子树
        if (node.rightType != 1) {
            preThreadedNode(node.right);
        }
    }

    //重载
    public void preThreadedNode() {
        this.preThreadedNode(root);
    }

    // 前序遍历线索二叉树
    public void preOrderThreadedList() {
        HeroNode node = root;
        while (node != null) {
            // 循环找leftType==1的节点
            System.out.println(node);
            if (node.leftType != 1) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    /**
     * 编写对二叉树进行后序序线索化的方法
     * 8 10 3 14 6 1
     *
     * @param node 当前需要线索化的节点
     */
    public void postThreadedNode(HeroNode node) {
        if (node == null) {
            return;
        }
        // 2. 先线索化左子树
        if (node.leftType != 1) {
            postThreadedNode(node.left);
        }
        // 3. 先线索化右子树
        if (node.rightType != 1) {
            postThreadedNode(node.right);
        }
        // 1. 线索化当前节点
        // (1) 处理当前节点的前驱节点
        if (node.left == null) {
            // 让当前节点的左指针指向前驱节点
            node.left = preNode;
            node.leftType = 1;
        }
        // (2) 处理当前节点的后继节点
        if (preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.rightType = 1;
        }
        // !!! 没处理一个节点后，让当前节点是下一个节点的前驱节点
        preNode = node;
    }

    //重载
    public void postThreadedNode() {
        this.postThreadedNode(root);
    }

    // 后序遍历线索二叉树 优雅而简洁
    public void postRecursionOrderThreadedList(HeroNode root){
        if (root.leftType==0){
            postRecursionOrderThreadedList(root.left);
        }
        if (root.rightType==0){
            postRecursionOrderThreadedList(root.right);
        }
        System.out.println(root);
    }

    // 后序遍历线索二叉树 此方法不通
//    public void postOrderThreadedList(){
//        HeroNode node = root;
//        while (node.left!=null){
//            node=node.left;
//        }
//        System.out.println(node);
//        while (node.rightType == 1) {
//            node=node.right;
//            System.out.println(node);
//        }
//        node = root.right;
//        while (node.left!=null&&node.left==node.right){
//            node=node.left;
//        }
//        System.out.println(node);
//        while (node.rightType == 1) {
//            node=node.right;
//            System.out.println(node);
//        }
//        System.out.println(root);
//    }

//    public void postOrderThreadedList() {
//        // 1. 找到后序遍历开始的节点
//        HeroNode node = root;
//        while (node.left != null) {
//            node = node.left;
//        }
//        HeroNode preNode = null; // 此前驱节点必须要有
//        while (node!=null){
//            // 右节点是线索
//            if (node.rightType==1){
//                System.out.println(node);
//                preNode=node;
//                node=node.right;
//            }else {
//                // 如果上个处理的节点是当前节点的右节点
//                if (node.right==preNode){
//                    System.out.println(node);
//                    if (node==root){
//                        return;
//                    }
//
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        BinaryTreeTwo binaryTreeTwo = new BinaryTreeTwo();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关羽");
        root.left = node2;
        root.right = node3;
        node3.left = node5;
        node3.right = node4;

        binaryTreeTwo.root = root;
        // 前序遍历测试
        //binaryTreeTwo.preOrder();
        // 中序遍历测试
        //binaryTreeTwo.infixOrder();
        // 后序遍历测试
        //binaryTreeTwo.postOrder();

        // 前序遍历查找
        // 前序遍历的次数 4次
//        System.out.println("前序遍历查找~");
//        int no=15;
//        HeroNode resultNode = binaryTreeTwo.preOrderSearch(no);
//        if (resultNode!=null){
//            System.out.printf("找到了该英雄 %s\n", resultNode);
//        }else {
//            System.out.printf("未找到编号为%d的英雄\n", no);
//        }

        // 删除节点
        System.out.println("删除前~，前序遍历");
        binaryTreeTwo.preOrder();
        binaryTreeTwo.deleteNode(1);
        System.out.println("删除后~，前序遍历");
        binaryTreeTwo.preOrder();
    }
}