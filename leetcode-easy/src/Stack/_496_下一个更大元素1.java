package Stack;

public class _496_下一个更大元素1 {
    public static void main(String[] args) {
        int[] a = {4,1,2};
        int[] b = {1,3,4,2};
        nextGreaterElement(a,b);
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int a = nums1[i];
            int b = -1;
            ints[i] = b;
            System.out.println(ints[i]);
            int index = -1;
            for (int j = 0; j < nums2.length; j++) {
                int h = nums2[j];
                if (a == h) {
                    index = j;
                    continue;
                }
                if (index != -1 && j > index && h > a) {
                    b = nums2[j];
                    ints[i] = b;

                    index = -1;
                    break;
                }
            }
        }
        return ints;
    }

}
