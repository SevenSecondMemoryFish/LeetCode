package Stack;

/**
 * 没有做出来
 */
public class _1642_可以到达的最远建筑 {
    public static void main(String[] args) {
        int[] ints = {4,12,2,7,3,18,20,3,19};
        furthestBuilding(ints, 10,2);
    }
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int index = 0;
        for (int i = 0; i < heights.length - 1; i++) {
            int a = heights[i];
            int b = heights[i + 1] - a;
            if (b > 0) {
                if (bricks > b) {
                    bricks -= b;
                    continue;
                }
                if (ladders > 0) {
                    ladders--;
                    continue;
                } else {
                    index = i;
                    break;
                }

            }
        }
        System.out.println(index);
        return index;
    }
}
