package 链表;

public class _Offer18_删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode current = pre;
        while (head != null) {
            if (head.val == val) {
                current.next = head.next;
            } else {
                current = current.next;
            }
            head = head.next;
        }
        return pre.next;
    }
}
