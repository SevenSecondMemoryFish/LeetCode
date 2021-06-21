package Stack;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class _636_函数的独占时间 {
    /**
     * 1.将字符串 ':'切割，如果是start直接将id和time组成的数组，放入栈中，
     * 2.如果此时字符串是end，则需要比较当前字符串和栈顶之间的差值interval = time - 栈顶time + 1，并且移出栈顶数组
     * 3.计算出来差值interval后，将它与res数组里面的ID对应的值，想加
     * 4.此时需要判断栈是否还有值，如果还有值，此时需要移出掉，id这端对应的间隔，因为已经计算过了。
     * @param n
     * @param logs
     * @return
     */
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ints = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < logs.size(); i++) {
            String s = logs.get(i);
            String[] split = s.split(":");
            Integer id = Integer.parseInt(split[0]);
            Integer time = Integer.parseInt(split[2]);
            if (split[1].equals("start")) {
                stack.push(new int[]{id,time});
            } else {

                int[] pop = stack.pop();
                int interval = time - pop[1] + 1;
                ints[pop[0]] += interval;
                if (!stack.isEmpty()) {
                    ints[stack.peek()[0]] -= interval;
                }
            }

        }
        return ints;
    }
}
