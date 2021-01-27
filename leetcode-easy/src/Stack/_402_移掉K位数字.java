package Stack;

import java.util.Stack;

public class _402_移掉K位数字 {
    public static void main(String[] args) {
        removeKdigits("112", 1);
    }

    /**
     * 核心思想，就是比较当前的字符和前一个字符大小，如果当前字符小于前一个字符，删除掉前一个字符，并将当前字符入栈
     *          如果当前字符，大于当前字符，直接入栈即可
     *          注意：入栈的时候，如果栈是空的，且 当前字符是「0」此时不需要入栈
     *          如果都遍历完毕后，k还是大于0的，这时候，需要从后面出栈k个字符即可
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Character character = chars[i];
            if (stack.isEmpty()) {
                if (character == '0')continue;
                stack.push(character);
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() > character && k > 0) {
                    stack.pop();
                    k--;
                } else {
                    break;
                }
            }
            if (stack.isEmpty() && character == '0')continue;
            stack.push(character);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty() || stack.peek() == '0' && stack.size() == 1) return "0";
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            buffer.insert(0, c);
        }
        return buffer.toString();
    }
}
