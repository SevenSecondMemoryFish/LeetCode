package Stack;

import java.util.Stack;

public class _1673_找出最具竞争力的子序列 {
    public static void main(String[] args) {
        int[] ints = {2,4,3,3,5,4,9,6};
        mostCompetitive(ints,4);
    }

    public static int[] nb_mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        /// nums里面所有数字都不能小于-1.所以stack不回成空的，所以不用判断stack是否为空，妙哉
        stack.push(-1);
        for (int i = 0; i < nums.length; i++) {
            Integer a = nums[i];
            while (stack.peek() > a && k - stack.size() + 1 < nums.length - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.push(a);
            }
        }
        int[] ret = new int[k];
        while (k > 0) {
            ret[--k] = stack.pop();
        }
        return ret;
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int[] ints = new int[k];
        k = nums.length - k;
        if (k <= 0)return nums;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            Integer a = nums[i];
            if (stack.isEmpty()) {
                stack.push(a);
                continue;
            }
            while (!stack.isEmpty()) {
                if (stack.peek() > a && k > 0) {
                    k--;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(a);
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        for (int i = 0; i < stack.size(); i++) {
            ints[i] = stack.get(i);
        }
        return ints;
    }
}
