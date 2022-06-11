package binarytree;

public class HeroNode {
    public int no;
    public String name;
    public HeroNode left;
    public HeroNode right;
    public int leftType; // 0 表示指向左子树， 1 表示指向前驱节点
    public int rightType; // 0 表示指向右子树， 1 表示指向后驱节点

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    // 前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
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
    // 中序遍历
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }
    // 前序遍历查找
    public HeroNode preOrderSearch(int no){
        if (this.no==no){
            return this;
        }
        HeroNode resultNode = null;
        if (this.left!=null){
            resultNode = this.left.preOrderSearch(no);
        }
        if (resultNode!=null){
            return resultNode;
        }
        if (this.right!=null){
            resultNode = this.right.preOrderSearch(no);
        }
        return resultNode;
    }
    // 中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode resultNode = null;
        if (this.left!=null){
            resultNode = this.left.infixOrderSearch(no);
        }
        if (resultNode!=null){
            return resultNode;
        }
        if (this.no==no){
            return this;
        }
        if (this.right!=null){
            resultNode = this.right.infixOrderSearch(no);
        }
        return resultNode;
    }
    // 后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode resultNode = null;
        if (this.left!=null){
            resultNode = this.left.postOrderSearch(no);
        }
        if (resultNode!=null){
            return resultNode;
        }
        if (this.right!=null){
            resultNode = this.right.postOrderSearch(no);
        }
        if (this.no==no){
            return this;
        }
        return resultNode;
    }
    // 删除子节点
    public void deleteNode(int no){
        if (this.left!=null&&this.left.no==no){
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.no==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.deleteNode(no);
        }
        if (this.right!=null){
            this.right.deleteNode(no);
        }
    }
}
