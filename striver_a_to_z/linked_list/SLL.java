/**
 * Singly Linked List
 * Basics
 */
class ListNode {

    public int data;
    public ListNode next;

    ListNode() {
        data = 0;
        next = null;
    }

    ListNode(int x) {
        data = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        data = x;
        this.next = next;
    }
}

public class SLL {

    public ListNode insertAtHead(ListNode head, int X) {
        ListNode newHead = new ListNode(X, head);
        return newHead;
    }

    public ListNode insertAtEnd(ListNode head, int x) {
        ListNode newTail = new ListNode(x);

        if (head == null) {
            return newTail; // list was empty, new node becomes head
        }

        ListNode curr = head;
        while (curr.next != null) { // traversing till tail
            curr = curr.next;
        }
        curr.next = newTail; // adding new tail to prev tail next

        return head;
    }

    public ListNode deleteHead(ListNode head) {
        head = head.next; // new head
        return head;
    }

    public ListNode removeLastNode(ListNode head) {
		if (head == null || head.next == null) // empty list or single node
			return null;
		
		ListNode curr = head, prev = null;
		while (curr.next != null) { // traversing till tail
			prev = curr;
			curr = curr.next;
		}
		
		prev.next = null; // deleting curr which stores the tail node;
		
		return head;
	}

    public int getLength(ListNode head) {
        int len = 0;

        while (head != null) {
            head = head.next;
            len++;
        }

        return len;
    }

    public boolean searchKey(ListNode head, int key) {
        while (head != null) {
            if (head.data == key) {
                return true;
            }

            head = head.next;
        }

        return false;
    }
}
