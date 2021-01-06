package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        int index = 0;
        ListNode b = head;
        while (b != null) {
            index++;
            b = b.next;
        }
        index = index/2 + 1;
        while (index > 0) {
            head = head.next;
            index--;
        }
        return head;
    }
}
