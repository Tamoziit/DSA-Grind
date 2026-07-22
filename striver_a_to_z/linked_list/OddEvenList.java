
import java.util.ArrayList;
import java.util.List;

public class OddEvenList {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public ListNode oddEvenList1(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head, even = head.next;
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        while (odd != null) {
            oddList.add(odd.val);
            odd = odd.next != null ? odd.next.next : null;
        }

        while (even != null) {
            evenList.add(even.val);
            even = even.next != null ? even.next.next : null;
        }

        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        for (int num : oddList) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }

        for (int num : evenList) {
            tail.next = new ListNode(num);
            tail = tail.next;
        }

        return dummy.next; // skipping the dummy
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
