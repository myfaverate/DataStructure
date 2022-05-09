package huffmantree;

public class Node implements Comparable<Node> {
    int value; 
    Node left; // 左节点
    Node right; // 右节点

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node node) {
        // 表示从小到大排序 x.compareTo(y)>0 x和y交换位置
        return this.value - node.value;
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
}
