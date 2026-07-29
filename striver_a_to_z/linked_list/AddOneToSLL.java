/**
 * Reverse SLL Technique
 * Time: O(N)
 * Space: O(1)
 */
public class AddOneToSLL {

    public ListNode addOne(ListNode head) {
        head = reverseList(head); // for adding +1 from LSB
        ListNode curr = head, prev = null;

        while (curr != null) {
            if (curr.val == 9) {
                curr.val = 0;
            } else {
                curr.val += 1;
                break;
            }

            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            ListNode msb = new ListNode(1); // 1 carry over from digits like 99, 999 -> 100, 1000
            prev.next = msb;
        }

        head = reverseList(head); // reversing back to the original order
        return head;
    }

    private ListNode reverseList(ListNode head) {
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
