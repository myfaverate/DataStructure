package hashtable;

import java.util.Scanner;

public class HashTable {
    EmployLinkedList[] employLinkedLists;
    int size;
    public HashTable(int size) {
        this.size = size;
        this.employLinkedLists = new EmployLinkedList[size];
        // 有坑，初始化哈希表
        for (int i = 0; i < size; i++) {
            employLinkedLists[i] = new EmployLinkedList();
        }
    }

    // 添加雇员
    public void add(Employee employee){
        int employLinkedListNo = hashFun(employee.id);
        // 哈希表未初始化，这里会报错
        employLinkedLists[employLinkedListNo].add(employee);
    }
    // 删除雇员
    public void delete(Employee employee){
        int employLinkedListNo = hashFun(employee.id);
        employLinkedLists[employLinkedListNo].delete(employee);
    }

    // 遍历哈希表
    public void list(){
        for (int i = 0; i < size; i++) {
            employLinkedLists[i].list(i);
        }
    }

    // 编写一个散列函数 取模法
    public int hashFun(int id){
        return id%size;
    }

    // 根据id查找雇员
    public void findEmployeeById(int id){
        // 使用散列散列函数确定到哪条链表中查找
        int employLinkedListNo = hashFun(id);
        Employee employeeById = employLinkedLists[employLinkedListNo].findEmployeeById(id);
        if (employeeById!=null){
            System.out.printf("在第%d条链表中找到该员工：%s\n",employLinkedListNo+1,employeeById);
        }else {
            System.out.println("未找到该雇员！");
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;
        while (true){
            System.out.println("add: 添加员工");
            System.out.println("delete: 删除员工");
            System.out.println("list: 显示员工");
            System.out.println("find: 查找员工");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key){
                case "add":
                    System.out.print("输入id: ");
                    id = scanner.nextInt();
                    System.out.print("输入名字: ");
                    name = scanner.next();
                    // 创建雇员
                    hashTable.add(new Employee(id, name));
                    break;
                case "delete":
                    System.out.print("输入id: ");
                    id = scanner.nextInt();
                    System.out.print("输入名字: ");
                    name = scanner.next();
                    // 创建雇员
                    hashTable.delete(new Employee(id, name));
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入id: ");
                    hashTable.findEmployeeById(scanner.nextInt());
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

}
