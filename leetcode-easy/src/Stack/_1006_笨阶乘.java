package Stack;

import java.util.Stack;

public class _1006_笨阶乘 {
    public static void main(String[] args) {
        clumsy(10);
    }
    public static int clumsy(int n) {
        char[] ints = new char[]{'*', '/', '+', '-'};
        int index = 0;
        int result = n;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i > 0 ; i--) {
            int b = index % 4;
            index++;
            char a = ints[b];
            if (a == '*') {
                result *= i;
            } else if (a == '/') {
                result /= i;
            } else if (a == '+') {
                result += i;
            } else {
                stack.push(result);
                result = 0 - i;
            }
        }
        stack.push(result);
        result = stack.get(0);
        for (int i = 1; i < stack.size(); i++) {
            result += stack.get(i);
        }
        return result;
    }
}
