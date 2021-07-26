package Stack;

import java.util.Stack;

public class _678_有效的括号字符串 {
    /**
     * 1.定义两个stack，一个保存'('的下标的stack，一个保存'*'下标的starStack
     * 2.当遇到'('的时候，将此时的下标保存的stack里面
     * 3.当遇到'*'的时候，将此时的下标保存到starStack里面
     * 4.当遇到')'的时候，判断此时stack 和 starStack 是否未空，为空这是false。不为空，先弹出'('stack的下标。再弹出'*'的下标
     * 5.遍历完毕后，从后面遍历判断stack和startStack的元素，如果stack的值大于starStack的值，则就出现了'*('的情况，则是false
     * 6.完毕后，再判断stack里面是否还有值
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        if (s.isEmpty())return true;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == '*') starStack.push(i);
            else {
                if (stack.isEmpty() && starStack.isEmpty())return false;
                else {
                    if (!stack.isEmpty())stack.pop();
                    else
                        starStack.pop();
                }
            }
        }
        while (!stack.isEmpty() && !starStack.isEmpty()) {
            if (stack.peek() > starStack.peek())return false;
            stack.pop();
            starStack.pop();
        }
        return stack.isEmpty();
    }
}
