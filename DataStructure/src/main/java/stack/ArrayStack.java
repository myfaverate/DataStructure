package stack;

import java.util.Arrays;

public class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组模拟栈
    private int top = -1; // 表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    // 入栈
    public void push(int num){
        if (isFull()){
            return;
        }
        top++;
        stack[top]=num;
    }
    // 出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value =  stack[top];
        top--;
        return value;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(Arrays.toString(stack.stack));
        System.out.println(stack.stack.length);
    }
}
