package Stack;

public class _215_数组中的第K个最大元素 {
    public static void main(String[] args) {
        int[] ints = {3,2,1,5,6,4};
        findKthLargest(ints,2);
    }
    public static int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int a = nums[j];
                int b = nums[j + 1];
                if (a < b) {
                    nums[ j + 1] = a;
                    nums[j] = b;
                }
            }
        }

        return nums[k];
    }
}
