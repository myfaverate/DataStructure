package stack;

import java.util.Stack;

public class ReversePolish {

    public int priority(int operator){
        if(operator=='*'||operator=='/'){
            return 1;
        }else if (operator=='+'||operator=='-'){
            return 0;
        }else {
            return -1;
        }
    }

    public String reverse(String infixStr){
        Stack<Character> stack = new Stack<>();
        // 中缀表达式转为逆波兰表达式
        // String infixStr = "1+(2-3)*4+3/5";
        String suffixStr = "";
        char ch;
        for (int i = 0; i < infixStr.length(); i++) {
            ch=infixStr.charAt(i);
            if (ch>='0'&&ch<='9'){ // 没问题
                suffixStr+=ch;
                suffixStr+=' ';
            }else if (stack.size()<=0||stack.peek()=='('){ // 没问题
                stack.push(ch);
            }else if (ch=='('){ // 没问题
                stack.push(ch);
            }else if (ch==')'){
                while (stack.peek()!='('){ // 没问题
                    suffixStr+=stack.pop();
                    suffixStr+=' ';
                }
                stack.pop();
            }else if (stack.size()>0){
                while (priority(ch)<=priority(stack.peek())){
                    suffixStr+=stack.pop();
                    suffixStr+=' ';
                    if (stack.size()<=0) break;
                }
                stack.push(ch);
            }
        }
        while (stack.size()>0) {suffixStr+=stack.pop();suffixStr+=' ';};
        return suffixStr.trim();
    }

    public static void main(String[] args) {
        ReversePolish reversePolish = new ReversePolish();
        System.out.println(reversePolish.reverse("(3+4)*5-6"));
        System.out.println(reversePolish.reverse("1+(2-3)*4+3/5"));
    }
}
