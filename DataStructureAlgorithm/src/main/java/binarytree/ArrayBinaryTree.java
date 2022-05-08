package binarytree;

public class ArrayBinaryTree {
    // 顺序存储二叉树
    public int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }
    /**
     * 完成前序遍历
     * @param index 数组下标
     */
    public void preOrder(int index){
        if (array==null||array.length==0){
            System.out.println("数组为空不能前序遍历~");
            return;
        }
        System.out.println(array[index]);
        if (index*2+1<array.length){
            preOrder(index*2+1);
        }
        if (index*2+2<array.length){
            preOrder(index*2+2);
        }
    }
    public void preOrder(){
        this.preOrder(0);
    }

    /**
     * 完成中序遍历
     * @param index 数组下标
     */
    public void infixOrder(int index){
        if (array==null||array.length==0){
            System.out.println("数组为空不能前序遍历~");
            return;
        }

        if (index*2+1<array.length){
            infixOrder(index*2+1);
        }
        System.out.println(array[index]);
        if (index*2+2<array.length){
            infixOrder(index*2+2);
        }
    }
    public void infixOrder(){
        this.infixOrder(0);
    }

    /**
     * 完成后序遍历
     * @param index 数组下标
     */
    public void postOrder(int index){
        if (array==null||array.length==0){
            System.out.println("数组为空不能前序遍历~");
            return;
        }

        if (index*2+1<array.length){
            postOrder(index*2+1);
        }
        if (index*2+2<array.length){
            postOrder(index*2+2);
        }
        System.out.println(array[index]);
    }
    public void postOrder(){
        this.postOrder(0);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
        //arrayBinaryTree.preOrder(); // 1 2 4 5 3 6 7
        //arrayBinaryTree.infixOrder(); // 4 2 5 1 6 3 7
        arrayBinaryTree.postOrder(); // 4 5 2 6 7 3 1
    }
}
