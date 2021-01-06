package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/intersection-of-tw
 */
public class _02_07_链表相交 {
    public static void main(String[] args) {
        int[] list = {4,1,8,4,5};
        int[] list1 = {5,0,1,8,4,5};
        ListNode node = ListNode.createList(list);
        ListNode node1 = ListNode.createList(list1);
        node = getIntersectionNode(node,node1);
        System.out.println(node);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        while (ha != hb) {
            ha = ha != null ? ha.next : headB;
            hb = hb != null ? hb.next : headA;
            System.out.println("ha:" + (ha != null ? ha.val : "null") + "----hb:" + (hb != null ? hb.val : "null"));
        }
        return ha;
    }
}
