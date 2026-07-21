/**
 * Time: O(N)
 * Space: O(1)
 */
public class ReverseSLL {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            ListNode next = curr.next; // save next before overwriting
            curr.next = prev; // reverse the link
            prev = curr; // advance prev
            curr = next; // advance curr
        }

        return prev; // prev ends up as new head
    }
}
