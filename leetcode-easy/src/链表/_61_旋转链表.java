package 链表;

import java.util.ArrayList;
import java.util.List;

public class _61_旋转链表 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListNode node = ListNode.createList(list);
        rotateRight(node,8);

    }

    /**
     * 解题思路：
     *  1，先获取head链表的个数
     *  2.判断k和head的个数的余数，如果余数未0 就是和原来一样
     *  3.余数就是变换的次数
     *  4.变换的策略就和删除链表的导出第几个N节点策略一样
     *      先移动start变换的次数n,
     *      再一起移动变化剩余的次数
     *      此时start对应就是最后一个元素，让它的next设置为head
     *      此时end对应的元素就是变化后的最后一个元素了，设置为null即可，注意设置null之前，end.next就是变化后的元素
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)return head;
        int index = 1;
        ListNode b = head;
        while (b.next != null) {
            b = b.next;
            index++;
        }
        if (k % index == 0) return head;
        k = k % index;
        ListNode start = head;
        ListNode end = head;
        while (k != 0) {
            start = start.next;
            k--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        ListNode a = end.next;
        end.next = null;
        start.next = head;
        return a;
    }
}
