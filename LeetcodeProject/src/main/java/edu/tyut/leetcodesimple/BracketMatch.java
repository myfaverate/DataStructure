package edu.tyut.leetcodesimple;

import java.util.Stack;

public class BracketMatch {
    public boolean match(String s) {
        Stack<Character> stack = new Stack<Character>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch == '(') stack.add(')');
            else if (ch == '[') stack.add(']');
            else if (ch == '{') stack.add('}');
            else if (stack.isEmpty()||ch != stack.peek()) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BracketMatch match = new BracketMatch();
        System.out.println(match.match("()[]{}"));
    }
}
