package hashtable;

public class EmployLinkedList {
    public Employee head = new Employee(-1,"head"); // head直接指向第一个Employee
    // 添加雇员 尾添加
    public void add(Employee employee){
        // 如果是第一个雇员
        if (head.next==null){
            head.next=employee;
            return;
        }
        // 如果不是第一个雇员
        Employee tmp=head.next;
        while (tmp.next!=null){
            tmp = tmp.next;
        }
        tmp.next=employee;
    }
    // 遍历链表的雇员信息
    public void list(int no){
        if (head.next==null){
            System.out.println("第"+(no+1)+"条链表为空~");
            return;
        }
        System.out.print("第"+(no+1)+"条链表信息为：");
        Employee tmp=head;
        while (tmp.next!=null){
            tmp=tmp.next;
            System.out.print(tmp+" ");
        }
        System.out.println();
    }
    // 删除链表的雇员信息
    public void delete(Employee employee){
        if (head.next==null){
            System.out.println("链表为空~, 不能删除！");
            return;
        }
        Employee tmp=head.next;
        Employee cur=head;
        while (tmp.next!=null&&tmp.id!=employee.id){
            tmp=tmp.next;
            cur=cur.next;
        }
        if (tmp.id==employee.id&&tmp.next!=null){
            cur.next=tmp.next;
        }else if (tmp.id==employee.id&&tmp.next==null){
            cur.next=null;
        }else System.out.println("链表元素不存在~");
    }
    // 查找雇员
    public Employee findEmployeeById(int id){
        // 判断乱标是否为空
        if (head.next==null){
            System.out.println("链表为空~");
            return null;
        }
        // 辅助指针
        Employee tmp = head.next;
        while (tmp.id!=id&&tmp!=null){
            tmp=tmp.next;
        }
        if (tmp.id==id){
            return tmp;
        }
        return null;
    }
}
