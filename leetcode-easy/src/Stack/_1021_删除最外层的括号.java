package Stack;

import java.util.Stack;

public class _1021_删除最外层的括号 {
    public static void main(String[] args) {
        removeOuterParentheses("(()())(())(()(()))");
    }

    public static String removeOuterParentheses(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        Stack<String> stringStack = new Stack<>();
        int before = 1;
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (stringStack.isEmpty()){
                stringStack.push(str);
            } else {
                if (str.equals(")") && stringStack.peek().equals("(")){
                    stringStack.pop();
                    if (stringStack.isEmpty()) {
                        String hh = s.substring(before,i);
                        stringBuffer.append(hh);
                        before = i + 2;
                        System.out.println(hh);
                    }
                } else {
                    stringStack.push(str);
                }
            }
        }
        return stringBuffer.toString();
    }
}
