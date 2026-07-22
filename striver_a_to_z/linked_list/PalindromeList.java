
class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class PalindromeList {
    /**
     * Time: O(N)
     * Space: O(N)
     */
    public boolean isPalindrome1(ListNode head) {
        StringBuilder list = new StringBuilder();

        while (head != null) {
            list.append(head.val);
            head = head.next;
        }

        int left = 0, right = list.length() - 1;
        while (left < right) {
            if (list.charAt(left) != list.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * Tortoise Hare  +  SLL Reversal
     * TIme: O(N)
     * Space: O(1)
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true; // base case; len = 0, 1
        }

        ListNode fast = head, slow = head, prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow; // stores mid - 1
            slow = slow.next; // stores mid
        }

        prev.next = null; // left half of SLL detached from right half
        ListNode left = head; // left half head
        ListNode right = reverse(slow); // right half head after reversal

        while (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode curr = head, prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev; // new head of reversed list
    }
}
