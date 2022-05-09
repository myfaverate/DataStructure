package huffmantree;

import java.util.ArrayList;
import java.util.Collections;

public class HuffmanTree {

    /**
     * 创建赫夫曼树
     * @param array 需要创建成赫夫曼树的数组
     * @return      创建好后的赫夫曼树的头节点
     */
    public Node createHuffmanTree(int[] array){
        // 1. 遍历array数组
        // 2. 将array的每一个元素构成一个node
        // 3. 将node放入ArrayList中
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : array) {
            nodes.add(new Node(value));
        }
        // 循环处理
        while (nodes.size()>1) {
            // 排序
            Collections.sort(nodes);
            //System.out.println(nodes);
            // 取出根节点权值最小的两颗二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parentNode = new Node(leftNode.value + rightNode.value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;
            // 从ArrayList删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 将parent加入到nodes
            nodes.add(parentNode);
        }
        return nodes.get(0);
    }

    // 前序遍历
    public void preOrder(Node node){
        if (node!=null){
            node.preOrder();
        }else System.out.println("是空树，不能遍历~");
    }

    public static void main(String[] args) {
        int[] array = {13,7,8,3,29,6,1};
        HuffmanTree huffmanTree = new HuffmanTree();
        Node node = huffmanTree.createHuffmanTree(array);
        huffmanTree.preOrder(node);
    }
}
