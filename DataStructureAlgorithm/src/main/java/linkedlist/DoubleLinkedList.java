package linkedlist;

public class DoubleLinkedList {
    // 先初始化一个头节点，头节点不要动，不存放具体的数据
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    // 尾添加
    public void addAtTail(DoubleHeroNode node){
        DoubleHeroNode tmp = head;
        while (tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=node;
        node.pre=tmp;
    }

    // 索引添加

    public void addIndex(int index, DoubleHeroNode newNode){
        if (index<0||index>=getLength()){
            throw new RuntimeException("索引越界！");
        }
        if (index==getLength()-1){
            addAtTail(newNode);
            return;
        }
        DoubleHeroNode tmp = head.next;
        for (int i = 0; i <= index; i++) {
            tmp = tmp.next;
        }
        tmp.pre.next=newNode;
        newNode.pre=tmp.pre;
        newNode.next=tmp;
        tmp.pre=newNode;
    }

    // 修改双向链表
    public void update(DoubleHeroNode node){
        DoubleHeroNode tmp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (tmp!=null){
            if (tmp.no==node.no){
                flag = true;
                break;
            }
            tmp=tmp.next;
        }
        if (flag){
            // 找到
            tmp.name = node.name;
            tmp.nickname = node.nickname;
        }else {
            // 没有找到
            System.out.printf("没有找到编号为 %d 的节点，不能修改\n", node.no);
        }
    }

    // 删除双向链表的的节点
    public void delete(int no){
        // 判断链表是否为空
        if (head.next==null){
            System.out.println("链表为空，无法删除");
            return;
        }
        // 因为双链表可以自我删除，所以 tmp = head.next
        boolean flag = false; // 判断是否找到待删除的节点
        DoubleHeroNode tmp = head.next;
        while (tmp!=null){
            if (tmp.no==no){
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        if (flag){
            tmp.pre.next = tmp.next;
            // 如果是最后一个节点有空指针异常
            if (tmp.next != null) {
                tmp.next.pre=tmp.pre;
            }
        }else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    // 获得链表的长度
    public int getLength(){
        DoubleHeroNode tmp = head;
        int count = 0;
        while (tmp.next!=null){
            count++;
            tmp=tmp.next;
        }
        return count;
    }

    // 遍历双向链表
    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        DoubleHeroNode tmp = head;
        while (tmp.next!=null){
            tmp = tmp.next;
            System.out.println(tmp);
        }
    }

    public static void main(String[] args) {
        // 双向链表的测试
        DoubleHeroNode hero1 = new DoubleHeroNode(1, "宋江", "及时雨");
        // DoubleHeroNode newHero1 = new DoubleHeroNode(1, "宋江1", "及时雨1");
        DoubleHeroNode hero2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
        DoubleHeroNode hero3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode hero4 = new DoubleHeroNode(4, "公孙胜", "入云龙");
        DoubleHeroNode hero5 = new DoubleHeroNode(5, "关胜", "青龙偃月刀");
        DoubleHeroNode hero6 = new DoubleHeroNode(6, "林冲", "豹子头");
        DoubleHeroNode hero7 = new DoubleHeroNode(7, "秦明", "霹雳火");
        DoubleHeroNode hero8 = new DoubleHeroNode(8, "呼延灼", "梁山泊第八条好汉");
        DoubleLinkedList list = new DoubleLinkedList();
        list.addAtTail(hero1);
        list.addAtTail(hero2);
        list.addAtTail(hero3);
        list.addAtTail(hero4);
        list.addAtTail(hero6);
        System.out.println(list.getLength());
        list.addIndex(3,hero5);
        list.addIndex(5,hero7);
        System.out.println(list.getLength());
        list.list();
    }
}
