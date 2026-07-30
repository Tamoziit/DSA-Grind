/**
 * Time: O(N)
 * Space: O(1)
 */
class ListNode {

    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}

public class DeleteTargetInDLL {

    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;

            if (curr.val == target) {
                if (curr.prev == null) {
                    head = curr.next;
                } else {
                    curr.prev.next = curr.next;
                }

                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }
            }

            curr = nextNode;
        }

        return head;
    }
}
