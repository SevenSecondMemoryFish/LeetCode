package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode a = new ListNode(0);
        a.next = head;
        ListNode b = a;
        while ( head != null) {
            if (head.val == val) {
                a.next = head.next;
            } else  {
                a = head;
            }
            head = head.next;
        }
        return b.next;
    }
}
