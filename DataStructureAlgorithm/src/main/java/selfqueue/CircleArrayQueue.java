package selfqueue;

public class CircleArrayQueue {
    private int maxSize; // 表示数组的最大容量
    // front 变量的含义做一个调整：front 就指向队列的第一个元素，也就是说 arr[front] 就是队列的第一个元素 初始值为0
    private int front;
    // rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间作为约定 初始值为0
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    // 判断队列是否满 有变化
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    // 判断队列是否为空 无变化
    public boolean isEmpty(){
        return rear == front;
    }
    // 添加数组到队列
    public void addQueue(int n){
        // 判断队列是否已满
        if (isFull()){
            throw new RuntimeException("队列已经满了！");
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }
    // 获取队列的数据，出队列
    public int getQueue(){
        // 判断队列是否为空
        if (isEmpty()){
            // 抛出异常
            throw new RuntimeException("队列为空，不能取数据！");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    // 显示队列的所有数据
    public void showQueue(){
        // 遍历
        if (isEmpty()){
            System.out.println("队列为空，没有数据！");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }
    // 计算有效数据个数
    public int size(){
        return (rear + maxSize - front) % maxSize;
    }
    // 显示队列头数据，不是取出
    public int headQueue(){
        // 判断
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据！");
        }
        return arr[front];
    }
}
