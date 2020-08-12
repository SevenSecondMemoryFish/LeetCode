public class DeleteDuplicates83 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        deleteDuplicates(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        var b = head;
        while (b != null && b.next != null) {
            if (b.val == b.next.val) {
                b.next = b.next.next;
            } else {
                b = b.next;
            }
        }
        return head;
    }
}
/**
 * 删除排序链表中的重复元素 url: https://leetcode-cn.com/problems/remove-duplicates-from-sorted
 *
 * 1.定义一个变量b等于传递过来的链表
 * 2.while循环这个链表，当最后一个链表为null的时候暂停循环
 * 3.当前的链表b的值 == b下一个链表值的时候，删除b的下一个链表，即：b.next = b.next.next
 *      注意点：当b删除一个链表时,其实我们head里面的值也会对应的删除，因为head链表里面保存的对象的指针和b中的是一样的，所以head里面的也能删除成功
 * 4,当不相等的时候，则b = b.next 开始判断下面的链表值
 */
