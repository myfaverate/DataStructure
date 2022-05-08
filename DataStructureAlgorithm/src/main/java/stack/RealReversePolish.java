package stack;

import java.util.Stack;

public class RealReversePolish {
    public int priority(int operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else if (operator == '+' || operator == '-') {
            return 0;
        } else {
            return -1;
        }
    }


    public String reverse(String infixStr) {
        Stack<Character> stack = new Stack<>();
        // 中缀表达式转为逆波兰表达式
        String suffixStr = "";
        char ch;
        int end;
        int i = 0;
        while (i < infixStr.length()) {
            ch = infixStr.charAt(i);
            if (ch >= '0' && ch <= '9') { // 没问题 (3+4)*5-60 // 3 4 + 5 * 6 -
                if (i == (infixStr.length() - 1)) suffixStr += ch;
                end = i;
                while (ch >= '0' && ch <= '9' && end < (infixStr.length()) - 1) {
                    suffixStr += ch;
                    end++;
                    ch = infixStr.charAt(end);
                    if (end == (infixStr.length() - 1)) {suffixStr += ch;i=end;}
                }
                suffixStr += ' ';
                if ((end - i) > 1) i = end - 1;
            } else if (stack.size() <= 0 || stack.peek() == '(') { // 没问题
                stack.push(ch);
            } else if (ch == '(') { // 没问题
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') { // 没问题
                    suffixStr += stack.pop();
                    suffixStr += ' ';
                }
                stack.pop();
            } else if (stack.size() > 0) {
                while (priority(ch) <= priority(stack.peek())) {
                    suffixStr += stack.pop();
                    suffixStr += ' ';
                    if (stack.size() <= 0) break;
                }
                stack.push(ch);
            }
            i++;
        }
        while (stack.size() > 0) {
            suffixStr += stack.pop();
            suffixStr += ' ';
        }
        return suffixStr.trim();
    }

    public static void main(String[] args) {
        RealReversePolish reversePolish = new RealReversePolish();
        //System.out.println(reversePolish.reverse("(30+40)*50-60-100"));
        System.out.println(reversePolish.reverse("(30+40)*50-60"));
        // 3 4 + 5 * 6 -
        // 正确答案 30 4 + 50 * 60 -
    }

}
