package linkedlist;

import java.util.Stack;

public class SingleLinkedList {
    // 定义SingleLinkedList管理链表
    // 初始化头节点，头节点不要动，不存放数据
    private HeroNode head = new HeroNode(0,"","");
    // 在尾部添加节点到单向列表
    // 思路，当不考虑编号顺序时
    // 1. 找到当前节点的最后节点
    // 2. 将最后这个节点的next 指向新的节点
    public void add(HeroNode heroNode){
        // 因为head节点不能动，因此我们需要一个辅助变量遍历
        HeroNode tmp = head;
        // 遍历链表，找到最后
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        // 当退出while循环时，tmp就指向了链表的最后
        // 当最后这个节点的next指向新的节点
        tmp.next = heroNode;
    }

    // 第二种方式在添加英雄时，根据排名将有效插入到指定位置
    // (如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode){
        // 因为头节点不能动，因此我们仍然通过一个辅助指针来帮助找到添加的位置
        // 因为单链表，因此我们找的tmp是位于添加位置的前一个节点，否则插入不了
        HeroNode tmp = head;
        boolean flag = false; // flag标志添加的编号是否存在，默认为false
        while (tmp.next!=null){
            if (tmp.next.no > heroNode.no){ // 位置找到，就在tmp后插入
                break;
            }else if (tmp.next.no == heroNode.no){
                // 说明希望添加的heroNode的编号已然存在
                flag = true; // 说明编号存在
                break;
            }
            tmp = tmp.next; // 后移，遍历当前链表
        }
        // 判断flag值
        if (flag){
            // 不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d 已经存在，不能加入\n", heroNode.no);
        }else {
            // 插入到链表中，tmp的后面， 关键
            heroNode.next = tmp.next;
            tmp.next = heroNode;
        }
    }

    // 修改节点的信息，根据no编号修改，即no编号不能更改
    public void update(HeroNode heroNode){
        // 定义一个辅助变量
        HeroNode tmp = head;
        if (tmp.next==null){
            System.out.println("链表为空~~");
            return;
        }
        // 找到需要修改的节点，根据no编号
        boolean flag = false;
        while (tmp.next!=null){
            if(tmp.no == heroNode.no){
                // 找到
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag){
            // 找到
            tmp.name = heroNode.name;
            tmp.nickname = heroNode.nickname;
        }else {
            // 没有找到
            System.out.printf("没有找到编号为 %d 的节点，不能修改\n", heroNode.no);
        }
    }

    // 删除节点
    // 思路：
    // 1. head头节点不能动，因此我们需要一个tmp的辅助节点，找到待删除节点的前一个节点
    // 2. 说明我们在比较时，是tmp.next.no和需要删除的节点的no比较
    public void delete(int no){
        HeroNode tmp = head;
        boolean flag = false; // 标识是否找到待删除的节点
        while (tmp.next!=null){
            if (tmp.next.no == no){
                // 找到待删除节点的前一个节点tmp
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag){
            // 找到 可以删除
            tmp.next = tmp.next.next;
        }else {
            System.out.printf("要删除的节点 %d 节点不存在\n", no);
        }
    }

    // 获取链表结点的个数
    public int getLength(){
        int count = 0;
        HeroNode tmp = head;
        while (tmp.next!=null){
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    // 新浪面试题：查找单链表的倒数第k个节点
    // 思路：链表总长度-k
    public HeroNode getLastKNode(int k){
        HeroNode tmp = head;
        // 判断链表是否为空
        if (tmp.next==null){
            return null;
        }
        int size = getLength();
        // 对k进行合法性校验
        if (k<=0||k>size){
            return null;
        }
        for (int i = 0; i <= (size-k); i++) {
            tmp=tmp.next;
        }
        return tmp;
    }

    // 腾讯面试题：反转链表
    public void reverseList(){
        // 判断链表是否为空，或者只有一个节点，无需反转直接返回
        if (head.next==null||head.next.next==null){
            return;
        }
        // 定义一个辅助指针，帮助我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode curNext = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        // 遍历原来的链表，没遍历一个节点就将其取出，并放在新的链表reverseHead的最前端
        while (cur!=null){
            curNext = cur.next; // 先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next; // 将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; // 将reverseHead连接到新的节点
            cur = curNext; // 让cur后移
        }
        // 将head.next指向reverseHead.next
        head.next = reverseHead.next;
        reverseHead.next = null;
    }

    // 逆序打印单链表(要求：不能破坏原来的单链表)
    // 利用栈
    public void reversePrint(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode tmp = head;
        while (tmp.next!=null){
            stack.add(tmp.next);
            tmp = tmp.next;
        }
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    // 合并两个单链表，参考链表反转
    // 合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
    public SingleLinkedList mergedLinkedList(SingleLinkedList singleLinkedList){
        HeroNode head1 = head;
        HeroNode tmp1 = head1.next;
        HeroNode head2 = singleLinkedList.head;
        HeroNode tmp2 = head2.next;
        if (head1.next==null&&head2.next==null){
            return this;
        }
        if (head1.next==null){
            return singleLinkedList;
        }
        if (head2.next == null){
            return this;
        }
        HeroNode newHead = new HeroNode(0, "", "");
        HeroNode prev = newHead;
        while (tmp1!=null&&tmp2!=null){
            if (tmp1.no<= tmp2.no){
                prev.next = tmp1;
                tmp1 = tmp1.next;
            }else {
                prev.next = tmp2;
                tmp2=tmp2.next;
            }
            prev = prev.next;
        }
        prev.next = tmp1 == null?tmp2:tmp1;
        head = newHead;
        return this;
    }

    // 显示链表 (遍历链表)
    public void list(){
        // 头节点引用一定不能改变，因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode tmp = head;
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

    // 测试
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode hero5 = new HeroNode(5, "关胜", "青龙偃月刀");
        HeroNode hero6 = new HeroNode(6, "林冲", "豹子头");
        HeroNode hero7 = new HeroNode(7, "秦明", "霹雳火");
        HeroNode hero8 = new HeroNode(8, "呼延灼", "梁山泊第八条好汉");
        // 创建链表
        SingleLinkedList linkedList = new SingleLinkedList();
        SingleLinkedList linkedList1 = new SingleLinkedList();
        // 不按照编号加入
//        linkedList.add(hero1);
//        linkedList.add(hero2);
//        linkedList.add(hero4);
//        linkedList.add(hero3);
        // 按照编号加入
//        linkedList.addByOrder(hero1);
//        linkedList.addByOrder(hero2);
//        linkedList.addByOrder(hero2);
//        linkedList.addByOrder(hero4);
//        linkedList.addByOrder(hero3);
        // 测试修改节点的代码
//        linkedList.addByOrder(hero1);
//        linkedList.addByOrder(hero2);
//        linkedList.addByOrder(hero4);
//        linkedList.addByOrder(hero3);
//        HeroNode heroUpdate = new HeroNode(1, "宋江1", "及时雨1");
//        linkedList.update(heroUpdate);
        // 测试删除节点的代码
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero5);
        linkedList.addByOrder(hero7);

        linkedList1.addByOrder(hero2);
        linkedList1.addByOrder(hero4);
        linkedList1.addByOrder(hero6);
        linkedList1.addByOrder(hero8);

        linkedList.mergedLinkedList(linkedList1).list();

//        linkedList.delete(1);
//        System.out.println(linkedList.getLength());
//        System.out.println("倒是第k个节点是："+linkedList.getLastKNode(4));
        // 显示
//        linkedList.reverseList();
//        linkedList.reversePrint();
//        linkedList.list();
    }
}
