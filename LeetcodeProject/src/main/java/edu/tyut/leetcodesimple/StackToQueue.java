package edu.tyut.leetcodesimple;

import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackToQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    public void push(int x){
        stack1.push(x);
    }
    public int pop(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek(){
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    public boolean empty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
