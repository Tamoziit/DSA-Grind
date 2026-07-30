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

public class RemoveDuplicatesFromDLL {

    public ListNode removeDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;

            if (curr.prev != null && curr.prev.val == curr.val) {
                curr.prev.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = curr.prev;
                }
            }

            curr = nextNode;
        }

        return head;
    }
}
