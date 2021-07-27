package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class _856_括号的分数 {
    public static void main(String[] args) {
        System.out.println(args);
        scoreOfParentheses("()()");
    }

    /**
     * 1.遍历字符串，将'('全部添加到stack里面
     * 2.当遍历的字符串是')',判断stack.peek() 是否为'('的时候,如果是，则需要遍历arrayList求和，并根据规则计算出相应的和
     *      如果不是，则需要将栈顶的数字添加到arrayList，切i--，等到下一次栈顶为'(',去求和
     * 3.再将stack里面的元素求和，则表示结果
     * @param s
     * @return
     */
    public static int scoreOfParentheses(String s) {
        if (s.equals("()"))return 1;
        Stack<Character> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (stack.peek() == '(') {
                    int index = 0;
                    for (int j = 0; j < arrayList.size(); j++) {
                        index += arrayList.get(j);
                    }
                    arrayList.clear();
                    stack.pop();
                    index = index == 0 ? 1 : index * 2;
                    char c10 = (char)(index + '0');
                    stack.push(Character.valueOf(c10));
                } else {
                    arrayList.add(stack.pop() - '0');
                    i--;
                }
            }
        }
        int a = 0;
        while (!stack.isEmpty()) {
            a += stack.pop() - '0';
        }
        return a;
    }
}
