package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _206_反转链表 {
    public static void main(String[] args) {
        int[] lists = {1,4,3,2,5,2};
        ListNode head = ListNode.createList(lists);
        dg_reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        ListNode b = null;
        while (head != null){
            ListNode a = head;
            head = head.next;
            a.next = b;
            b = a;
        }
        return b;
    }

    public static ListNode dg_reverseList(ListNode head) {
        if (head == null || head.next == null)return head;
        ListNode newListNode = dg_reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newListNode;
    }
}
