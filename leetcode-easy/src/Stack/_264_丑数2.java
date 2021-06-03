package Stack;

public class _264_丑数2 {
    public static void main(String[] args) {
       int j = nthUglyNumber(15);
        System.out.println(j);
    }

    public  int nthUglyNumber1(int n) {
        int[] ints = new int[n+1];
        ints[1] = 1;
        for (int ix1 = 1, ix2 = 1, ix3 = 1, i = 2; i <= n; i++) {
            int a = ints[ix1] * 2, b = ints[ix3] * 3, c = ints[ix3] * 5;
            int d = Math.min(a, b);
            d = Math.min(d,c);
            if (d == a ) ix1++;
            if (d == b) ix2++;
            if (d == c)ix3++;
            ints[i] = d;
        }
        return ints[n];
    }

    /**
     * // ans 用作存储已有丑数（从下标 1 开始存储，第一个丑数为 1）
     *         int[] ans = new int[n + 1];
     *         ans[1] = 1;
     *         // 由于三个有序序列都是由「已有丑数」*「质因数」而来
     *         // i2、i3 和 i5 分别代表三个有序序列当前使用到哪一位「已有丑数」下标（起始都指向 1）
     *         for (int i2 = 1, i3 = 1, i5 = 1, idx = 2; idx <= n; idx++) {
     *             // 由 ans[iX] * X 可得当前有序序列指向哪一位
     *             int a = ans[i2] * 2, b = ans[i3] * 3, c = ans[i5] * 5;
     *             // 将三个有序序列中的最小一位存入「已有丑数」序列，并将其下标后移
     *             int min = Math.min(a, Math.min(b, c));
     *             // 由于可能不同有序序列之间产生相同丑数，因此只要一样的丑数就跳过（不能使用 else if ）
     *             if (min == a) i2++;
     *             if (min == b) i3++;
     *             if (min == c) i5++;
     *             ans[idx] = min;
     *         }
     *         return ans[n];
     *
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/ugly-number-ii/solution/gong-shui-san-xie-yi-ti-shuang-jie-you-x-3nvs/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */

    public static int nthUglyNumber(int n) {
        if (n == 1)return 1;
        int index = 0;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int b = i;
            while (b % 5 == 0) {
                b = b / 5;
            }
            while ( b % 3 == 0 ) {
                b = b / 3;
            }
            while (b % 2 == 0) {
                b = b / 2;
            }
            if ( b == 1 ) {
                index++;
                System.out.println(i);
            }
            if (index == n)return i;
        }

        return index;
    }
}
