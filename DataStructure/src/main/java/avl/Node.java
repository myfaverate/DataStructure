package avl;

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

    // 返回左子树的高度
    public int leftHeight(){
        if (left==null){
            return 0;
        }
        return left.height();
    }
    // 返回右子树的高度
    public int rightHeight(){
        if (right==null){
            return 0;
        }
        return right.height();
    }
    // 返回以该节点为根节点的树的高度，以该节点为根节点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0: right.height())+1;
    }

    /**
     * 以递归的形式添加节点，注意满足二叉排序树的要求
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断传入的节点的值和当前子数的根节点的值的关系
        if (node.value < this.value) {
            // 如果当前节点左子节点为null
            if (this.left == null) {
                this.left = node;
            } else {
                // 递归向左子树添加
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                // 递归向右子树添加
                this.right.add(node);
            }
        }

        // 当添加完一个节点后，如果(右子树的高度-左子树的高度)>1, 左旋转
        if (rightHeight()-leftHeight()>1){
            // 如果它的右子树的左子树的高度大于它的右子树的右子树的高度
            if (right!=null&&right.leftHeight()>right.rightHeight()){
                // 先对右子节点进行右旋转
                right.rightRotate();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }
        // 当添加完一个节点后，如果(左子树的高度-右子树的高度)>1, 右旋转
        if (leftHeight()-rightHeight()>1){
            // 如果它的左子树的右子树的高度大于它的左子树的左子树的高度
            if (left!=null&&left.rightHeight()>left.leftHeight()){
                // 先对当前节点的左节点(左子树)->左旋转
                left.leftRotate();
                // 在对当前节点进行右旋转
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * 查找要删除的节点
     *
     * @param value 希望删除的节点的值
     * @return 如果找到返回该节点，否则返回null
     */
    public Node search(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value) {
            // 如果左子节点为空
            if (this.left == null) {
                return null;
            }
            return this.left.search(value);
        } else {
            // 如果右子节点为空
            if (this.right == null) {
                return null;
            }
            return this.right.search(value);
        }
    }

    /**
     * 查找要删除的节点的父节点
     *
     * @param value 希望删除的节点的值
     * @return 如果找到返回要删除节点的父节点，否则返回null
     */
    public Node searchParent(int value) {
        // 如果当前节点就是要删除的节点的父节点，就返回
        if (this.left!=null&&this.left.value==value||this.right!=null&&this.right.value==value){
            return this;
        }else {
            // 如果要查找的值小于当前节点的值，并且当前节点的左子节点不为空
            if (value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if (value>=this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }
    // 左旋转的方法
    public void leftRotate(){
        // 1. 创建新的节点，以当前节点的值
        Node newNode = new Node(value);
        // 2. 把新的节点的左子树设置成当前节点的左子树
        newNode.left=left;
        // 3. 把新的节点的右子树设置成当前节点的右子树的左子树
        newNode.right=right.left;
        // 4. 把当前节点的值替换成右子节点的值
        value=right.value;
        // 5. 把当前节点的右子树设置成当前节点右子节点的右子节点
        right=right.right;
        // 6. 把当前节点的左子树(左子节点)设置成新的节点
        left=newNode;
    }
    // 右旋转的方法
    public void rightRotate(){
        Node newNode = new Node(value);
        newNode.right=right;
        newNode.left=left.right;
        value=left.value;
        left=left.left;
        right=newNode;
    }
}
