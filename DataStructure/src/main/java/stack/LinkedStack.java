package stack;
import linkedlist.ListNode;

import java.util.Stack;

public class LinkedStack {
    ListNode head = new ListNode(0);
    ListNode top=head;
    int maxSize;
    public LinkedStack(int maxSize) {
        this.maxSize=maxSize;
        ListNode node;
        ListNode tmp=head;
        for (int i = 0; i < maxSize; i++) {
            node=new ListNode(i);
            tmp.next=node;
            tmp=tmp.next;
        }
    }
    public boolean isFull(){
        return getLength()==maxSize;
    }
    public boolean isEmpty(){
        return top==head;
    }

    public int getLength(){
        int count=0;
        ListNode tmp=head;
        while (tmp!=top){
            tmp=tmp.next;
            count++;
        }
        return count;
    }
    // 入栈
    public void push(int num){
        if (isFull()){
            return;
        }
        top.next.val=num;
        top=top.next;
    }
    // 出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value = top.val;
        ListNode tmp=head;
        while (tmp.next!=top){
            tmp=tmp.next;
        }
        top=tmp;
        return value;
    }
    // 遍历栈
    public void showList(){
        Stack<ListNode> stack = new Stack<>();
        if (isEmpty()){
            System.out.println("栈为空");
            return;
        }
        ListNode tmp=head;
        while (tmp!=top){
            tmp=tmp.next;
            stack.add(tmp);
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    // 遍历链表
    public void show(){
        ListNode tmp=head;
        while (tmp.next!=null){
            tmp=tmp.next;
            System.out.println(tmp);
        }
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack(10);
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        System.out.println(linkedStack.pop());
        // 遍历栈
        linkedStack.showList();
    }
}
