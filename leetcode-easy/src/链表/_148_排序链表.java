package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/sort-list/
 */
public class _148_排序链表 {
    public ListNode sortList(ListNode head) {
        ListNode sortListNode = new ListNode(0);
        ListNode cur = head;
        ListNode pre = sortListNode;
        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode nex = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = sortListNode;
            cur = nex;
        }
        return sortListNode.next;
    }
}
