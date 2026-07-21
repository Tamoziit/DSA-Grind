/**
 * DLL
 * Basics
 */
class ListNode {

    public int data;
    public ListNode prev;
    public ListNode next;

    ListNode() {
        data = 0;
        prev = null;
        next = null;
    }

    ListNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    ListNode(int data, ListNode prev, ListNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
};

public class DLL {

    public ListNode insertBeforeHead(ListNode head, int data) {
        ListNode newHead = new ListNode(data, null, head);
        if (head != null) {
            head.prev = newHead;
        }

        return newHead; // new head
    }

    public ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode newHead = head.next;
        newHead.prev = null;

        return newHead;
    }

    public ListNode reverseDLL(ListNode head) {
        ListNode left = head, right = head;
        int len = 0;

        while (right.next != null) {
            right = right.next;
            len++;
        }

        int i = 0;
        while (i <= len / 2) {
            int temp = left.data;
            left.data = right.data;
            right.data = temp;

            left = left.next;
            right = right.prev;
            i++;
        }

        return head;
    }
}
