import static java.lang.Integer.min;

public class MySqrt69 {
    public static void main(String[] args) {
        int sqrt = mySqrt(16);
        System.out.println(sqrt);
    }

    /**
     * 获取平方根的正数
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int mid = (max + min) / 2;
            if (x / mid == mid) {
                max = mid;
                min = max;
            } else if (x / mid < mid) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }

    /**
     * 获取最近接近的平方根
     * @param x
     * @return
     */
    public static int near_mySqrt(int x) {
        if (x <= 1) return x;
        int min = 0;
        int max = x;
        int h = x,dd = 0;
        while (max - min > 1) {
            int mid = (max + min) / 2;
            int ss = Math.abs(mid*mid -x);
            if (h > ss){
                h = ss;
                dd = mid;
            }
            if (x / mid < mid) {
                max = mid;
            } else {
                min = mid;
            }
        }
        return dd;
    }
}
/**
 * x的平方根，leetcode url: https://leetcode-cn.com/problems/sqrtx/
 * 解题思路：
 *  1.while循环max和min差值大于1，因为如果>=1的话，表明两个数相邻，二分查找就会死循环，
 *  2.根据二分查找，获取中间数mid
 *  3.判断mid的平方和x比较，如果 > 则，max就是mid，继续二分查找，如果相等 则不需要继续查找，其他则 min = mid，继续循环
 *
 * 2,near_mySqrt
 *  查询最接近x的平方根
 *  1.思路和上面基本一样
 *  2.二分查找数和x之间的差值 hh,以及确定的数dd,
 *  3.判断每次循环之二分查找数的平方和x之间的差值，以及上一次的差值，取最小值复制给hh，并且记录此时的二分查找数复制给dd即可
 */
