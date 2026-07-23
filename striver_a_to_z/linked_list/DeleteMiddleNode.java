/**
 * Tortoise Hare
 * Time: O(n/2)
 * Space: O(1)
 */
public class DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head, prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow; // mid - 1
            slow = slow.next; // mid
        }

        prev.next = slow.next; // deleting mid

        return head;
    }
}
