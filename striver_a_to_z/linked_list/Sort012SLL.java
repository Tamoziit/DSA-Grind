/**
 * Pointers
 * Time: O(n)
 * Space: O(1)
 */
public class Sort012SLL {

    public ListNode sortList(ListNode head) {
        ListNode zeroHead = null, zeroTail = null, oneHead = null, oneTail = null, twoHead = null, twoTail = null;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == 0) {
                if (zeroHead == null) {
                    zeroHead = curr;
                    zeroTail = curr;
                } else {
                    zeroTail.next = curr;
                    zeroTail = curr;
                }
            } else if (curr.val == 1) {
                if (oneHead == null) {
                    oneHead = curr;
                    oneTail = curr;
                } else {
                    oneTail.next = curr;
                    oneTail = curr;
                }
            } else if (curr.val == 2) {
                if (twoHead == null) {
                    twoHead = curr;
                    twoTail = curr;
                } else {
                    twoTail.next = curr;
                    twoTail = curr;
                }
            }

            curr = curr.next;
        }

        // Using dummy node to simplify joining, skipping empty buckets
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        if (zeroHead != null) {
            tail.next = zeroHead;
            tail = zeroTail;
        }
        if (oneHead != null) {
            tail.next = oneHead;
            tail = oneTail;
        }
        if (twoHead != null) {
            tail.next = twoHead;
            tail = twoTail;
        }

        tail.next = null; // terminating the final sorted list

        return dummy.next;
    }
}
