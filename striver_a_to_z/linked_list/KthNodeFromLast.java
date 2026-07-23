/**
 * Fast & Slow Pointer
 * Time: O(k)
 * Space: O(1)
 */
public class KthNodeFromLast {

    public int getKthFromLast(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;

        // Moving fast pointer N+1 steps ahead to create a gap
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return - 1; // k exceeds list length
            }

            fast = fast.next;
        }

        if (fast == null) {
            return - 1; // k exceeds list length
        }

        // Moving both pointers until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow = slow.next; // kth ele
        return slow.val;
    }
}
