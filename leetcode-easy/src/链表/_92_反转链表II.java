package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/reverse-linked-list-ii/
 */
public class _92_反转链表II {
    /**
     * 先找到需要翻转节点的前一个节点pre，
     * 再开始反转节点到需要结束的节点
     *      先找到开始第一个反转节点head
     *      找到第二个反转节点nex
     *      将第二个反转节点和第一个互换
     *      一次类推，到结束的反转节点
     * @param head 链表
     * @param m    开始旋转的
     * @param n     结束旋转
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        // pre 为旋转节点的前一个节点，也是m-1节点
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        // 讲head指向开始选择的第一个节点
        head = pre.next;
        for (int i = m; i < n; i++) {
            // 获取到需要旋转的下一个节点
            ListNode nex = head.next;
            // 讲第一个节点的next，指点下一个节点的next节点
            head.next = nex.next;
            // 讲第二个节点的next指点开始的第一个节点
            nex.next = pre.next;
            /// 将开始节点，指向下一个节点
            pre.next = nex;
        }
        return dummy.next;
    }
}
