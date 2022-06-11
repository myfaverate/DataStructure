package linkedlist;

public class CircleSingleLinkedList {
    // 约瑟夫问题解决
    // 相当于头节点，不可动
    ListNode first = null;
    /**
     * 新建指定数量节点的环形链表
     * @param nums
     */
    public void addNode(int nums){
        if (nums<1){
            System.out.println("nums的值不正确");
            return;
        }
        ListNode cur = null;
        for (int i = 1; i <= nums; i++) {
            ListNode node = new ListNode(i);
            if (i==1){
                first = node;
                first.next = node;
                cur = first;
            }else {
                cur.next=node;
                cur=cur.next;
                cur.next=first;
            }
        }
    }
    // 遍历当前环形链表
    public void showList(){
        // 判断链表是否为空
        if (first==null){
            System.out.println("环形链表为空");
            return;
        }
        // 因为first指针不能动，因此我们仍然使用一个辅助指针来完成遍历
        ListNode cur = first;
        while (true){
            if (cur.next==first){
                System.out.print(cur.val);
                break;
            }
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.println();
    }

    // 计算出圈的顺序
    public void order(int startNo, int countNum){
        // 先对数据进行校验
        if (first==null||startNo<1||startNo>getLength()){
            System.out.println("参数有误，请重新输入");
            return;
        }
        // 创建一个辅助指针
        ListNode cur = first;
        // 实现让辅助指针指向first的前一个结点
        while (true){
            if (cur.next==first){
                break;
            }
            cur=cur.next;
        }
        // 移动first指针和cur指针
        for (int i = 0; i < startNo-1; i++) {
            first=first.next;
            cur=cur.next;
        }
        // 出圈
        while (true){
            if (cur==first){
                // 说明圈中只有一个节点
                break;
            }
            // 移动first指针和cur指针
            for (int i = 0; i < countNum-1; i++) {
                first=first.next;
                cur=cur.next;
            }
            System.out.print(first.val+"->");
            first = first.next;
            cur.next=first;
        }
        System.out.println(first.val);
    }

    // 获得环形链表节点个数
    public int getLength(){
        int count = 0;
        ListNode cur = first;
        while (true) {
            count++;
            if (cur.next == first) {
                break;
            }
            cur=cur.next;
        }
        return count;
    }

    public static void main(String[] args) {
        // 测试，构建和遍历
        CircleSingleLinkedList singleLinkedList = new CircleSingleLinkedList();
        singleLinkedList.addNode(5);
        System.out.println(singleLinkedList.getLength());
        singleLinkedList.showList();
        singleLinkedList.order(2,3);
    }
}
