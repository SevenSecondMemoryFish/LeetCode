package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/swapping-nodes-in-a-linked-list/
 */
public class _1721_交换链表中的节点 {
    public static void main(String[] args) {
        int[] list = {7,9,6,6,7,8,3,0,9,5};
        ListNode header = ListNode.createList(list);
        header = swapNodes(header, 5);
        System.out.println(header);
    }
    public static ListNode swapNodes(ListNode head, int k) {
        ListNode p = head, r = head,l = head, pre = new ListNode(0), lp = pre, rp = pre;
        pre.next = head;
        while (k != 1) {
            lp = p;
            p = p.next;
            k--;
        }
        l = p;
        while (p.next != null) {
            rp = r;
            r = r.next;
            p = p.next;
        }
        if (l != r) {
            lp.next = r;
            rp.next = l;
            ListNode temp = r.next;
            r.next = l.next;
            l.next = temp;
        }
        return pre.next;
    }
}
