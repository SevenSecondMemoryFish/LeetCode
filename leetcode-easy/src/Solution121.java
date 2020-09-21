public class Solution121 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int max = double_maxProfit(prices);
        System.out.println(max);
    }

    /**
     * 购买股票，只能购买一次卖一次
     * @param prices
     * @return
     * leetcode:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     */
    public static int maxProfit(int[] prices) {
        int index = 0;
        int min = -1;
        int max = -1;
        int c = 0;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i] || min == -1) {
                min = prices[i];
                index = i;
                max = -1;
            }
            if ((index < i || max == -1 ) && max < prices[i] && prices[i] - min > c) {
               max = prices[i];
               c = max - min;
            }
        }
        return c;
    }

    public static int nb_maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i]-max);
            min = Math.min(min,prices[i]);
        }
        return max;
    }

    /**
     * 可以多次购买股票买入和卖出
     * 使用贪心算法进项计算
     * lettcode： https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     */

    static int double_maxProfit(int[] prices) {
        int resut = 0;
        for (int index = 1; index <prices.length; index++) {
            if (prices[index] > prices[index-1]) {
                resut += prices[index] - prices[index -1];
            }
        }
        return resut;
    }
}
