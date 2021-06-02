package Stack;

import java.util.Stack;

public class _1047_删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }

    public static String removeDuplicates(String s) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (stringStack.isEmpty()) {
                stringStack.push(str);
            } else {
                if (stringStack.peek().equals(str)) {
                    stringStack.pop();
                } else {
                    stringStack.push(str);
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stringStack.isEmpty()) {
            stringBuffer.insert(0,stringStack.pop());
        }
        return stringBuffer.toString();
    }
}
