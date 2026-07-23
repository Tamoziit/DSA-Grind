
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortSLL {

    /**
     * Time: O(nlgn)
     * Space: O(n)
     */
    public ListNode sortList1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) { // O(n)
            list.add(curr.val);
            curr = curr.next;
        }

        Collections.sort(list); // O(nlgn)

        curr = head;
        int i = 0;
        while (curr != null) {
            curr.val = list.get(i);
            i++;
            curr = curr.next;
        }

        return head;
    }

    /**
     * Time: O(nlgn)
     * Space: O(1)
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMid(head);
        ListNode leftHead = head, rightHead = middle.next;
        middle.next = null;

        leftHead = sortList2(leftHead);
        rightHead = sortList2(rightHead);

        return merge(leftHead, rightHead);
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (leftHead != null && rightHead != null) {
            if (leftHead.val <= rightHead.val) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }

            temp = temp.next;
        }

        if (leftHead != null) {
            temp.next = leftHead;
        } else {
            temp.next = rightHead;
        }

        return dummy.next;
    }
}
