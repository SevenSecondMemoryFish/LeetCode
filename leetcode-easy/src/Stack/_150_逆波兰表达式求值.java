package Stack;

import java.util.Stack;

public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stringStack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            if (str.equals("+")) {
                int index = stringStack.pop();
                int index1 = stringStack.pop();
                stringStack.push(index + index1);
            } else if (str.equals("-")) {
                int index = stringStack.pop();
                int index1 = stringStack.pop();
                stringStack.push(index1 - index);
            } else if (str.equals("/")) {
                 int index = stringStack.pop();
                int index1 = stringStack.pop();
                stringStack.push(index1 / index);
            } else if (str.equals("*")) {
                int index = stringStack.pop();
                int index1 = stringStack.pop();
                stringStack.push(index * index1);
            } else {
                stringStack.push(Integer.valueOf(str));
            }
        }
     return stringStack.pop();
    }
}
