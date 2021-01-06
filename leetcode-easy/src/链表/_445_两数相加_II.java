package 链表;

/**
 * leetcode： https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class _445_两数相加_II {
    public static void main(String[] args) {
        int[] list1 = {7,2,4,3};
        int[] list2 = {5,6,4};
        addTwoNumbers(ListNode.createList(list1), ListNode.createList(list2));
    }

    /**
     * 1.讲链表l1和l2反转
     * 2,在使用连个链表想加算法，求出链表
     * 3.反转求出的新链表即可
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverseListNode(l1);
        ListNode b = reverseListNode(l2);
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
        return reverseListNode(node.next);
    }

    static ListNode  reverseListNode(ListNode head) {
        ListNode node = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = node;
            node = cur;
            cur = nex;
        }
        return node;
    }
}
