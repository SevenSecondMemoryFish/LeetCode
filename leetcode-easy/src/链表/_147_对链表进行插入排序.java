package 链表;

/**
 * leetcode: https://leetcode-cn.com/problems/insertion-sort-list/
 */
public class _147_对链表进行插入排序 {
    public static void main(String[] args) {
        int[] list = {-1,5,3,4,0};
        ListNode listNode = ListNode.createList(list);
        listNode = nb_insertionSortList(listNode);
        System.out.println(listNode);

        ListNode dummpHead = null;
        ListNode cur = listNode;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = dummpHead;
            dummpHead = cur;
            cur = nex;
        }

    }

    /**
     * 1.找到将要插在那个node后面 pre
     * 2.将当前的node插入到pre后面
     * 3.并将pre指向dummyHead。继续下次遍历
     * @param head
     * @return
     */
    public static ListNode nb_insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummyHead;
        while (cur != null) {
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode nex = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = dummyHead;
            cur = nex;
        }
        return dummyHead.next;
    }

    public static ListNode insertionSortList2(ListNode head) {
        ListNode sort = new ListNode(-2147483648);
        while (head != null) {
            ListNode nex = head.next;
            ListNode b = sort.next;
            ListNode before = sort;
            if (b != null){
                boolean isInset = false;
                while (b != null) {
                    if (before.val <= head.val && b.val > head.val) {
                        ListNode node1 = new ListNode(head.val);
                        before.next = node1;
                        node1.next = b;
                        isInset = true;
                        break;
                    }
                    before = before.next;
                    b = b.next;
                }
                if (!isInset) {
                    before.next = new ListNode(head.val);;
                }
            } else {
                sort.next = new ListNode(head.val);
            }
            head = nex;
        }
        return sort.next;
    }
}
