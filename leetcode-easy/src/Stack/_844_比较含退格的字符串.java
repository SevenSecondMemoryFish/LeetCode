package Stack;

import java.util.Stack;

public class _844_比较含退格的字符串 {
    public static void main(String[] args) {

    }

    public static boolean backspaceCompare(String s, String t) {
        Stack<String> oneStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String hh = String.valueOf(s.charAt(i));
            if (hh.equals("#")) {
                if (!oneStack.isEmpty()) {
                   oneStack.pop();
                }
            } else {
                oneStack.push(hh);
            }
        }
        Stack<String> twoStack = new Stack<>();
        for (int i = 0; i < t.length(); i++) {
            String hh = String.valueOf(t.charAt(i));
            if (hh.equals("#")) {
                if (!twoStack.isEmpty()) {
                   twoStack.pop();
                }
            } else {
                twoStack.push(hh);
            }
        }
        if (twoStack.size() != oneStack.size()) {
            return false;
        } else {
            while (!oneStack.isEmpty()){
                if (!(oneStack.pop().equals(twoStack.pop()))){
                    return false;
                }
            }
        }
        return true;
    }
}
