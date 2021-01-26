package Stack;

import java.nio.charset.Charset;
import java.util.Set;
import java.util.Stack;

public class _227_基本计算器II {

    public static void main(String[] args) {
        char[] chars = "23455".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            int hh = (c - '0') + 2;
            System.out.println(hh);
        }
        calculate(" 3+5 / 2 ");
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';
        s = s.trim();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + (c-'0');
            }
            if (!Character.isDigit(c) || i >= s.length() - 1) {
                switch (operation) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                operation = c;
                num = 0;
            }
        }
        Integer before = stack.pop();
        while (!stack.isEmpty()) {
            before += stack.pop();
        }
        return before;
    }
}
