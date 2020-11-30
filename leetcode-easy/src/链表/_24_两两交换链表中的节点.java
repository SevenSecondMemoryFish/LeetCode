package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class _24_两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode a = head;
        int index = 1;
        ListNode before = null;
        while (a != null) {
            int value = a.val;
            if (index % 2 == 0) {
                a.val = before.val;
                before.val = value;
            } else {
                before = a;
            }
            index++;
            a = a.next;
        }
        return head;
    }
}
