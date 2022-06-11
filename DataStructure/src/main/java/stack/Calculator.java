package stack;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表达式：");
        String expression=scanner.nextLine();// 中缀表达式
        scanner.close();
        OperateStack numStack = new OperateStack(10);
        OperateStack operateStack = new OperateStack(10);
        int num1=0;
        int num2=0;
        int operate=0;
        int result=0;
        char ch;
        String strNum=""; // 用于拼接多位数
        for (int i = 0; i < expression.length(); i++) {
            ch=expression.charAt(i);
            if (operateStack.isOperator(ch)){
                if (!operateStack.isEmpty()){
                    if (operateStack.priority(ch)<=operateStack.priority(operateStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        operate=operateStack.pop();
                        result=numStack.calculate(num1,num2,operate);
                        numStack.push(result);
                        operateStack.push(ch);
                    }else {
                        operateStack.push(ch);
                    }
                }else {
                    operateStack.push(ch);
                }
            }else {
                // 有问题
                strNum+=ch;
                // 如果ch已经是expression的最后一位，就直接入栈
                if(i==expression.length()-1){
                    numStack.push(Integer.valueOf(strNum));
                }else {
                    if (operateStack.isOperator(expression.charAt(i + 1))) {
                        numStack.push(Integer.valueOf(strNum));
                        // 清空strNum
                        strNum = "";
                    }
                    // numStack.push(ch-48);
                }
            }
        }
        while (!operateStack.isEmpty()){
            num1=numStack.pop();
            num2=numStack.pop();
            operate=operateStack.pop();
            result=numStack.calculate(num1,num2,operate);
            numStack.push(result);
        }
        System.out.printf("表达式 %s = %d", expression, numStack.pop());
    }
}
