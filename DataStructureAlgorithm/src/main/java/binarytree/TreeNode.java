package binarytree;

public class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
