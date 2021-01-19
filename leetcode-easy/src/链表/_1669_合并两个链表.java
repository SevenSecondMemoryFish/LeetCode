package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/merge-in-between-linked-lists/
 */
public class _1669_合并两个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = null;
        ListNode last = null;
        int index = 1;
        ListNode current = list1;
        while (current != null) {
            if (index == a) {
                first = current;
            }
            if (index - 1 == b) {
                last = current.next;
            }
            index++;
            current = current.next;
        }
        first.next = list2;
        current = list2;
        while (current.next != null) {
            current = current.next;
        }
        current.next = last;
        return list1;
    }
}
