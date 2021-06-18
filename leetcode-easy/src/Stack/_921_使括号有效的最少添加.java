package Stack;

import java.util.Stack;

public class _921_使括号有效的最少添加 {

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() > 0) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                } else {
                    stack.push(c);
                }
            }
        }
        int index = 0;
        while (!stack.isEmpty()) {
            index++;
            stack.pop();
        }
        return index;
    }
}
