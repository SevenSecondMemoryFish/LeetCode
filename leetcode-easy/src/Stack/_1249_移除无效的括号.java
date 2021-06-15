package Stack;

import java.util.HashMap;
import java.util.Stack;

public class _1249_移除无效的括号 {
    public static void main(String[] args) {

         minRemoveToMakeValid1("lee(t(c)o)de)");
    }
    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] inArray = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c != '(' && c != ')')continue;
            if (c == '(') {
                stack.push(i);
            } else if (c == ')'){
                if (!stack.isEmpty()) {
                     inArray[stack.pop()] = true;
                     inArray[i] = true;
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (inArray[i] || (c != '(' && c != ')')) {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

     public static String minRemoveToMakeValid1(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (!c.equals("(") && !c.equals(")"))continue;
            if (stack.isEmpty()) {
                stack.push(String.valueOf(i));
                stack.push(c);
                continue;
            }
            String a = stack.peek();
            if (c.equals(")") && a.equals("(")) {
                stack.pop();
                stack.pop();
            } else {
                stack.push(String.valueOf(i));
                stack.push(c);
            }
        }
         StringBuffer buffer = new StringBuffer(s);
        while (!stack.isEmpty()) {
             stack.pop();
             int h = Integer.parseInt(stack.pop());
             buffer.deleteCharAt(h);

        }
        return buffer.toString();
    }
}
