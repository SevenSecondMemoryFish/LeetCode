package 链表;

public class _86_分隔链表 {
    public static void main(String[] args) {
        int[] lists = {1,4,3,2,5,2};
        ListNode listNode = ListNode.createList(lists);
        listNode = partition(listNode,3);
        System.out.println(listNode);
    }

    /**
     * 解题思路：
     *  创建两个链表，minListNode和maxListNode,以及minListNode的最后节点  minLastNode 以及对应的maxListNode的对应最后节点maxLastNode
     *  遍历给定的链表：当val小于 给定值x 是，添加到minLastNode中，并跟新minLastNode
     *  遍历完毕后，组装列表：
     *      maxLastNode的next是null了
     *      minListNode的nex便是maxListNode的next
     *  返回minListNode的next即可
     *  注意：minListNode和maxListNode都创建了一个head节点，所以返回的时候，都是它们的next节点
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)return head;
        ListNode minListNode = new ListNode(0);
        ListNode minLastNode = minListNode;
        ListNode maxListNode = new ListNode(0);
        ListNode maxLastNode = maxListNode;
        ListNode a = head;
        while (a != null) {
            if (a.val >= x){
                maxLastNode.next = a;
                maxLastNode = maxLastNode.next;
            } else {
                minLastNode.next = a;
                minLastNode = minLastNode.next;
            }
            a = a.next;
        }
        maxLastNode.next = null;
        minLastNode.next = maxListNode.next;
        return minListNode.next;
    }
}
