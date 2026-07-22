
import java.util.HashMap;
import java.util.Map;

public class DetectCyclePos {
    /**
     * HashMap
     * Time: O(N)
     * Space: O(N)
     */
    public ListNode detectCycle1(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode curr = head;
        int idx = 0;

        while (curr != null) {
            if (map.getOrDefault(curr, -1) == -1) {
                map.put(curr, idx);
                curr = curr.next;
                idx++;
            } else {
                return curr;
            }
        }

        return null;
    }

    /**
     * Tortoise Hare
     * Time: O(N)
     * Space: O(1)
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) { // cycle detected
                // proceed to starting pt. of loop
                slow = head; // slow reset to head to move towards starting pt.

                while (slow != fast) { // moving until re-collision
                    // both slow & fast proceed by 1 step
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // starting pt. of loop
            }
        }

        return null;
    }
}
