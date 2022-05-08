package selfqueue;

public class ArrayQueue {
    private int maxSize; // 表示队列的最大容量
    private int front; // 表示数组的队列头
    private int rear; // 表示数组的队列尾
    private int[] arr; // 该数组用于存放数据，模拟队列
    // 创建队列构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置
        this.rear = -1; // 指向队列尾部，分析出rear是指向队列尾的最后一个数据
    }
    // 判断队列是否满
    public boolean isFull(){
        return rear == maxSize-1;
    }
    // 判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }
    // 添加数组到队列
    public void addQueue(int n){
        // 判断队列是否已满
        if (isFull()){
            throw new RuntimeException("队列已经满了！");
        }
        rear++; // 让rear后移
        arr[rear] = n;
    }
    // 获取队列的数据，出队列
    public int getQueue(){
        // 判断队列是否为空
        if (isEmpty()){
            // 抛出异常
            throw new RuntimeException("队列为空，不能取数据！");
        }
        front++;
        return arr[front];
    }
    // 显示队列的所有数据
    public void showQueue(){
        // 遍历
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }
    // 显示队列头数据，不是取出
    public int headQueue(){
        // 判断
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front+1];
    }
}
