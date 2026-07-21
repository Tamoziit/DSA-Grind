/**
 * Tortoise-Hare: Fast & Slow Pointer Technique
 * Time: O(M)
 * Space: O(1)
 */
public class MiddleOfSLL {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 2-steps
            slow = slow.next; // 1-step -> will eventually contain the mid ele.
        }

        return slow;
    }
}
