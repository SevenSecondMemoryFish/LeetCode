package Stack;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 没做对
 */
public class _1541_平衡括号字符串的最少插入次数 {
    public static void main(String[] args) {
        //minInsertions("(((()(()((())))(((()())))()())))(((()(()()((()()))");
    }

    public static int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.size() > 1) {
                    int length = stack.size() - 1;
                    Character c1 = stack.get(length);
                    Character c2 = stack.get(length - 1);
                    if (c1 == ')' && c2 == '(') {
                        stack.pop();
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
            Character c = stack.pop();
            if (c == '(') {
                index += 2;
            } else {
                if (stack.isEmpty()) {
                    index += 2;
                } else {
                    stack.pop();
                    index += 1;
                }
            }
        }
        System.out.println(index);
        return index;
    }
}
