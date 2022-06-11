package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class PolandNotation {

    public List<String> getListString(String suffixExpression) {
        // 将suffixExpression按空格分割
        String[] strings = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String string : strings) {
            list.add(string);
        }
        return list;
    }

    public int calculate(List<String> lists) {
        // 创建栈
        Stack<String> stack = new Stack<>();
        for (String list : lists) {
            // 这里使用正则表达式来去除数
            if (list.matches("\\d+")) {
                stack.push(list);
            } else {
                // pop出两个数再运算
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int result = 0;
                if (list.equals("+")) {
                    result = num1 + num2;
                } else if (list.equals("-")) {
                    result = num2 - num1;
                } else if (list.equals("*")) {
                    result = num1 * num2;
                } else if (list.equals("/")) {
                    result = num2 / num1;
                }else {
                    throw new RuntimeException("运算符有误！");
                }
                // 把结果入栈
                stack.push(String.valueOf(result));
            }
        }
        // 最后留在stack中的是结果
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        RealReversePolish reversePolish = new RealReversePolish();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个中缀表达式：");
        String infixExpression = scanner.nextLine();
        scanner.close();
        String suffixExpression = reversePolish.reverse(infixExpression);
        System.out.println(infixExpression);
        // 思路：
        // 1. 将逆波兰表达式，以空格分割，放入ArrayList
        // 2. 将ArrayList传递给一个方法，遍历ArrayList，配合栈完成计算
        PolandNotation notation = new PolandNotation();
        List<String> list = notation.getListString(suffixExpression);
        System.out.println(list);
        int result = notation.calculate(list);
        System.out.println(result);
        // 多位数
        // 4*(8+6)*5-6+8*8+5/5
        // 1+((2+3)*4)-5
    }
}
