package 链表;

public class _2_两数想加 {
    public static void main(String[] args) {
        ListNode l3 = new ListNode(9);
        ListNode l2 = new ListNode(4);
        l2.next = l3;
        ListNode l1 = new ListNode(2);
        l1.next = l2;





        ListNode l7 = new ListNode(9);
        ListNode l6 = new ListNode(4);
        l6.next = l7;
        ListNode l5 = new ListNode(6);
        l5.next = l6;
        ListNode l4 = new ListNode(5);
        l4.next = l5;
        addTwoNumbers(l1,l4);


    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        Integer sum = 0;
        ListNode last = null;
        while ( a != null && b != null) {
            sum = a.val + b.val + sum / 10;
            a.val = sum % 10;
            if (a.next == null) {
                last = a;
            }
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            sum = a.val + sum / 10;
            a.val = sum % 10;
            if (a.next == null) {
                last = a;
            }
            a = a.next;
        }
        while (b != null) {
            sum = b.val + sum / 10;
            b.val = sum % 10;
            last.next = b;
            last = b;
            b = b.next;
        }
        if (sum / 10 > 0) {
            last.next = new ListNode(sum/10);
        }
        return l1;
    }
}
