package Stack;

import java.util.Stack;
import java.util.regex.Pattern;

public class _394_字符串解码 {
    public static void main(String[] args) {
        decodeString("3[a2[c]]");
    }

    public static String decodeString(String s) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer charBuffer = new StringBuffer();
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];

            if (c == '[') {
                if (!charBuffer.toString().isEmpty()) {
                    stack.push(charBuffer.toString());
                }
                charBuffer = new StringBuffer();
                continue;
            }
            if (c == ']') {
                String before = stack.pop();
                if (isNumber(before)) {
                    int index = Integer.valueOf(before);
                    String hh = charBuffer.toString();
                    while (index > 1) {
                        charBuffer.append(hh);
                        index--;
                    }
                } else {
                    charBuffer.insert(0, before);
                }
                if (!charBuffer.toString().isEmpty()) {
                    stack.push(charBuffer.toString());
                }
                charBuffer = new StringBuffer();
            } else {
                charBuffer.append(c);
            }
        }
        buffer.append(charBuffer);
        charBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            String before = stack.pop();
            if (isNumber(before)) {
                int index = Integer.valueOf(before);
                while (index > 0) {
                    buffer.insert(0, charBuffer);
                    index--;
                }
            } else {
                charBuffer.insert(0, before);
            }
        }
        buffer.insert(0,charBuffer);
        return buffer.toString();
    }

    static Boolean isNumber(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length; i++) {
             if (!Character.isDigit(chars[i]))return false;
        }
        return true;
    }
}
