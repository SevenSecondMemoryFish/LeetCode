import javax.swing.tree.TreeNode;

public class MaxDepth104 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {    //  3   9   20  15
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);     //  3   9   = 1
        int right = maxDepth(root.right);   //  3   20
        return Math.max(left,right) + 1;
    }
}
/**
 * 1.leetcode 104题目： https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/submissions/
 * 2.解题思路：
 *  2.1 使用递归，从一个点往下一直查找，等查找到left和right是null的时候，标识此点到头
 *  2.2 当查到到left到头的点后，就需要查找right的点，等left和right都到头了，就需要给此节点 +1 ，找到头的节点后，就需要往上推节点即可
 */




