package Stack;

import java.util.Stack;

public class _1544_整理字符串 {
    public static void main(String[] args) {
        makeGood("leEeetcode");
    }

    public static String makeGood(String s) {
        if(s.length() < 2)return s;
        char[] chars = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char before = chars[index];
            if (before == 0) {
                chars[index] = a;
                continue;
            }
            if (a > 'Z') {/// 小写
                if(before > 'a') {
                    chars[index + 1] = a;
                    index++;
                } else {
                    if (before + 32 == a + 0) {
                        chars[index] = 0;
                        index = Math.max(index-1, 0);
                    }else {
                        chars[index + 1] = a;
                        index++;
                    }
                }
            } else {/// 大写
                if(before < 'a') {
                    chars[index + 1] = a;
                    index++;
                } else {
                    if (before - 32 == a + 0) {
                        chars[index] = 0;
                        index = Math.max(index-1, 0);
                    }else {
                        chars[index + 1] = a;
                        index++;
                    }
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <= index; i++) {
            if (chars[i] == 0)continue;
            stringBuffer.append(String.valueOf(chars[i]));
        }
        return stringBuffer.toString();
    }

    public String stackMakeGood(String s) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (stringStack.isEmpty()){
                stringStack.push(str);
                continue;
            }
            String before = stringStack.peek();
            if (!str.equals(before)) {
                if (str.toUpperCase().equals(before) || str.toLowerCase().equals(before)) {
                    stringStack.pop();
                } else {
                    stringStack.push(str);
                }
            } else {
                stringStack.push(str);
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stringStack.isEmpty()) {
            stringBuffer.insert(0,stringStack.pop());
        }
        return  stringBuffer.toString();
    }


}
