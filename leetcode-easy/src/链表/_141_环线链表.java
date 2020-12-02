package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class _141_环线链表 {
    /**
     * 解题思路：
     *  使用快慢指针来查找，两个指针是否能重合，重合即标识是个环形链表
     *      慢指针：一次走一步
     *      快指针：一次走多步
     *      如果是环形指针，两个指针绝对可以指向一个链表元素
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)return true;
        }
        return false;
    }
}
