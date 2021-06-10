package Stack;

import java.lang.reflect.Array;
import java.util.*;

public class _316_去除重复字母 {
    public static void main(String[] args) {
        System.out.println("addfaa".indexOf("a",2));
        System.out.println(removeDuplicateLetters("bcabc"));;
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c))continue;
            while (!stack.isEmpty()&&stack.peek() > c && s.indexOf(stack.peek(),i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        char chars[]=new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i]=stack.get(i);
        }
        return new String(chars);
    }
}
