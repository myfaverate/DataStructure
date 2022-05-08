package edu.tyut.leetcodesimple;

public class MyLinkedList {
    Node head = new Node(0);
    public MyLinkedList() {

    }

    public int get(int index) {
        if (index<0||index>getLength()||index>=getLength()){
            return -1;
        }
        if (head.next==null){
            return 0;
        }
        Node tmp = head.next;
        for (int i = 0; i < getLength(); i++) {
            if (i == index){
                break;
            }
            tmp=tmp.next;
        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node tmp = head;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public void addAtIndex(int index, int val) {
        if (index<0||index>getLength()){
            return;
        }
        Node newNode = new Node(val);
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index<0||index>=getLength()){
            return;
        }
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next=cur.next.next;
    }
    // 获得链表长度
    public int getLength(){
        int count = 0;
        Node tmp = head;
        while (tmp.next!=null){
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    // 展示链表
    public void show(){
        // 头节点引用一定不能改变，因为头节点不能动，因此我们需要一个辅助变量来遍历
        Node tmp = head;
        // 判断链表是否为空
        if (tmp.next == null){
            System.out.println("链表为空");
            return;
        }
        while (tmp.next!=null){
            tmp = tmp.next;
            System.out.println(tmp);
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
        myLinkedList.get(1);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.get(3);
        myLinkedList.addAtHead(1);
        myLinkedList.deleteAtIndex(4);
        myLinkedList.show();
    }
}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }
}
