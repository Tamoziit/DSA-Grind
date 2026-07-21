/**
 * Fast - Slow pointer
 * Time: O(N)
 * Space: O(1)
 */
public class SLLCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true; // pointers meet - cycle exists
            }
        }

        return false; // pointers don't meet - cycle doesn't exists
    }
}
