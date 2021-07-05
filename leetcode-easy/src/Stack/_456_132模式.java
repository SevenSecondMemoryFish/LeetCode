package Stack;

import java.util.Stack;

public class _456_132模式 {

    /**1.只需要找到数组的最大值k。再找到最大值后面的最大值j 以及最大值前面的小于j的值即可
     * 使用倒序查找比较容易获取最大值
     * 使用单掉栈，倒序查找最大值，k表示最大值后面第二大的下标
     * k > -1 表示已经找到一个num[j] > num[k]这样一对值了
     * nums[k] > nums[i] 只要在找到 num[i] < num[k]的值即可
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3)return false;
        Stack<Integer> stack = new Stack<>();
        int k = -1;
        for (int i = length - 1; i >= 0 ; i--) {
            if (k > -1 && nums[k] > nums[i]) return true;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                k = stack.pop();
            }
            stack.push(i);
        }
        return false;
    }
}
