package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class _328_奇偶链表 {
    public static void main(String[] args) {
        int[] list = {1,2,3,4,5};
        ListNode listNode = ListNode.createList(list);
        oddEvenList(listNode);
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)return head;
        ListNode current = head;
        int index = 1;
        ListNode odd = current;
        ListNode pre = head.next;
        ListNode even = pre;
        current = current.next.next;
        while (current != null) {
            ListNode nex = current.next;
            if (index % 2 != 0) {//
                odd.next = current;
                current.next = pre;
                even.next = nex;
                even = nex;
                odd = current;
            }
            index++;
            current = nex;
        }
        return head;
    }
}
