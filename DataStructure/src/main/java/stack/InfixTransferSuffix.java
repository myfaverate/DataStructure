package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixTransferSuffix {
    // 获得运算符优先级
    public int priority(String operator){
        int num=0;
        if (operator.equals("*")||operator.equals("/")){
            num = 2;
        }
        if (operator.equals("+")||operator.equals("-")){
            num = 1;
        }
        return num;
    }
    // 方法：将得到的中缀表达式对应的List=>后缀表达式对应的List
    public List<String> parseSuffixExpression(List<String> infixExpressionList){
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        // 遍历infixExpression
        for (String infix : infixExpressionList) {
            // 如果是一个数字入list
            if (infix.matches("\\d+")){
                list.add(infix);
            }else if (infix.equals("(")){
                stack.push(infix);
            }else if (infix.equals(")")){
                // 如果是右括号")",则依次弹出stack栈顶的运算符，并压入list，直到遇到左括号，并将左括号弹出
                while (!stack.peek().equals("(")){
                    list.add(stack.pop());
                }
                stack.pop();
            }else {
                while (stack.size()>0&&priority(stack.peek())>=priority(infix)){
                    list.add(stack.pop());
                }
                stack.push(infix);
            }
        }
        while (stack.size()>0){
            list.add(stack.pop());
        }
        return list;
    }
    // 方法：将 中缀表达式转换成对于的list
    public List<String> toInfixExpressionList(String infixExpression){
        // 定义一个List，存放中缀表达式对应的内容
        List<String> lists = new ArrayList<>();
        int i=0;
        String str; // 对多位数的拼接
        char ch;
        while (i<infixExpression.length()){
            ch = infixExpression.charAt(i);
            // 如果 ch 为一个非数字，需要加入到lists
            if (ch<'0'||ch>'9'){
                lists.add(String.valueOf(ch));
                i++;
            }else {
                // 如果是一个数，考虑多位数
                // 比较简单
                str=""; // 先将str置空
                while (i<infixExpression.length()&&ch>='0'&&ch<='9'){
                    str+=ch;
                    i++;
                    if(i<infixExpression.length()) ch = infixExpression.charAt(i);
                }
                lists.add(str);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        // 完成将一个中缀表达式转成后缀表达式的功能
        // 1+((2+3)*4)-5
        // 1 2 3 + 4 * + 5 -
        // 因为直接对str进行操作，不方便，因此先将1+((2+3)*4)-5 => [1,+,(,(,2,+,3,),*,4,),-,5]
        String infixExpression = "2*3+5-7+(5*4+(8/3+4-8))*8*5";
        InfixTransferSuffix infixTransferSuffix = new InfixTransferSuffix();
        List<String> infixList = infixTransferSuffix.toInfixExpressionList(infixExpression);
        List<String> suffixList = infixTransferSuffix.parseSuffixExpression(infixList);
        // [2, 3, *, 5, +, 7, -, 5, 4, *, 8, 3, /, 4, +, 8, -, +, 8, *, 5, *, +]
        // [2, 3, *, 5, +, 7, -, 5, 4, *, 8, 3, /, 4, +, 8, -, +, 8, *, 5, *, +]
        PolandNotation notation = new PolandNotation();
        int calculate = notation.calculate(suffixList);
        System.out.println(calculate);
    }
}
