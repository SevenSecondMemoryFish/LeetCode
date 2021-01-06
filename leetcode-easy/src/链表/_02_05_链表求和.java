package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/sum-lists-lcci/
 */
public class _02_05_链表求和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        int sum = 0;
        ListNode node = new ListNode(0);
        ListNode current = node;
        while (a != null || b != null) {
            int aValue = a != null ? a.val : 0;
            int bValue = b != null ? b.val : 0;
            int value = aValue + bValue + sum;
            ListNode c = a != null ? a : b;
            c.val = value % 10;
            sum = value / 10;
            current.next = c;
            current = c;
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        if (sum > 0) {
            current.next = new ListNode(sum);
        }
        return node.next;
    }

}
