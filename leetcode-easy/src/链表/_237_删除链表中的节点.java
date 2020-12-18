package 链表;

/**
 * leetcode:  https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {
    /**
     * 其实真正的是删除的是node后面的那个元素
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
