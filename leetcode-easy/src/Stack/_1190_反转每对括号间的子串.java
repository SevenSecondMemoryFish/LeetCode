package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class _1190_反转每对括号间的子串 {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                ArrayList<Character> arrayList = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    arrayList.add(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                for (int j = 0; j < arrayList.size(); j++) {
                    stack.push(arrayList.get(i));
                }
                arrayList.clear();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.insert(0,stack.pop());
        }
        return buffer.toString();
    }
}
