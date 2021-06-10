package Stack;

import java.util.Stack;

public class _1209_删除字符串中的所有相邻重复项II {
    public static void main(String[] args) {
        removeDuplicates("deeedbbcccbdaa",3);
    }
    public static String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c =  s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                index = 1;
                continue;
            }
            if (c == stack.peek() && index == k-1) {
                while (index > 0) {
                    stack.pop();
                    index--;
                }
                boolean isLoop = true;
                    index = 2;
                    while (isLoop&&stack.size() >= index) {
                        isLoop = stack.peek() == stack.get(stack.size() - index);
                        if (isLoop) {
                            index++;
                        }
                    }
                    index = index != 2 ? index - 1 : 1;
                continue;
            } else {
                if (c == stack.peek()) {
                   index++;
                } else {
                    index = 1;
                }
            }
            stack.push(c);
        }

        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.insert(0,stack.pop());
        }
        return buffer.toString();
    }
}
