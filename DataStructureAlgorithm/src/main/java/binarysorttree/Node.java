package binarysorttree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     * 以递归的形式添加节点，注意满足二叉排序树的要求
     * @param node
     */
    public void add(Node node){
        if (node==null){
            return;
        }
        // 判断传入的节点的值和当前子数的根节点的值的关系
        if (node.value<this.value){
            // 如果当前节点左子节点为null
            if (this.left==null){
                this.left=node;
            }else {
                // 递归向左子树添加
                this.left.add(node);
            }
        }else {
            if (this.right==null){
                this.right=node;
            }else {
                // 递归向右子树添加
                this.right.add(node);
            }
        }
    }

    // 中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
}
