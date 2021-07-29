package Stack;

import java.util.Stack;

public class _1081_不同字符的最小子序列 {

    /**
     * 1.当stack里面已经包含了当前的元素的时候，直接抛弃次元素
     * 2.重点：判断当stack.peek 大于当前的元素c的时候，并且c后面还有同样的元素的时候，就可以把stack顶元素pop出
     */
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.contains(s.charAt(i)))continue;
            while (!stack.isEmpty() && s.charAt(i) < stack.peek() && s.indexOf(stack.peek(),i) != -1) {
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            buffer.append(stack.get(i));
        }
        return buffer.toString();
    }
}
