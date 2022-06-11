package stack;

public class OperateStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组模拟栈
    private int top = -1; // 表示栈顶

    public OperateStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    // 入栈
    public void push(int num){
        if (isFull()){
            return;
        }
        top++;
        stack[top]=num;
    }
    // 出栈
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int value =  stack[top];
        top--;
        return value;
    }
    // 查看栈顶的值
    public int peek(){
        return stack[top];
    }
    // 返回运算符优先级，优先级越高，数字越大，Java中char的本质是int
    public int priority(int operator){
        if(operator=='*'||operator=='/'){
            return 1;
        }else if (operator=='+'||operator=='-'){
            return 0;
        }else {
            return -1;
        }
    }
    public boolean isOperator(int operator){
        return operator=='+'||operator=='-'||operator=='*'||operator=='/';
    }
    // 计算
    public int calculate(int num1,int num2,int operator){
        int result=0;
        switch (operator){
            case '+':
                result=num2+num1;
                break;
            case '-':
                result=num2-num1;
                break;
            case '*':
                result=num2*num1;
                break;
            case '/':
                result=num2/num1;
                break;
            default:
                break;
        }
        return result;
    }
}
