/**
 * Tortoise Hare
 * Time: O(N)
 * Space: O(1)
 */
public class LengthOfLoop {

    public int lengthOfLoop(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) { // cycle detected
                // walking a counter upto collision pt.
                ListNode counter = slow.next;
                int len = 1;

                while (counter != slow) {
                    counter = counter.next;
                    len++;
                }

                return len; // length of loop = L1 + d
            }
        }

        return 0;
    }
}
