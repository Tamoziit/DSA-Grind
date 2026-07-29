import java.util.HashMap;
import java.util.Map;

public class IntersectionPointOf2LL {
    /**
     * HashMap (Brute)
     * Time: O(n + m)
     * Space: O(n) or O(m) [based on which list is hashed]
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Map<ListNode, Integer> nodes = new HashMap<>();
        int idx = 0;

        ListNode curr = headA;
        while (curr != null) {
            nodes.put(curr, idx);
            idx++;

            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (nodes.getOrDefault(curr, -1) != -1) {
                return curr;
            }

            curr = curr.next;
        }

        return null;
    }

    /**
     * Better Approach
     * Time: O(n) + O(m) + O(n - m) + O(m) = O(2n + m)
     * Space: O(1)
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        int n1 = 0, n2 = 0;

        while (currA != null) { // O(n)
            n1++;
            currA = currA.next;
        }

        while (currB != null) { // O(m)
            n2++;
            currB = currB.next;
        }

        if (n1 < n2) { // len(list B) > len(list A)
            return collisionPoint(headA, headB, n2 - n1);
        } else { // len(list A) > len(list B)
            return collisionPoint(headB, headA, n1 - n2);
        }
    }

    private ListNode collisionPoint(ListNode listMin, ListNode listMax, int d) {
        // walking the longer list ptr. upto the head of the smaller list (n2 - n1 steps = d)
        while (d != 0) { // O(n - m)
            listMax = listMax.next;
            d--;
        }

        while (listMin != listMax) { // O(m) [assuming m is smaller]
            listMin = listMin.next;
            listMax = listMax.next;
        }

        return listMin; // either the ptrs. hit collision pt. & break out of loop, or they meet at null (no collision)
    }

    /**
     * 2-Pointer (Optimal)
     * Time: O(n + m)
     * Space: O(1)
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == headB)
            return headA;

        ListNode t1 = headA, t2 = headB;

        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;

            if (t1 == t2) {
                return t1; // collision & no collision (null)
            }

            // moving ptrs. to oppo. list heads on reaching the end
            if (t1 == null) {
                t1 = headB;
            }

            if (t2 == null) {
                t2 = headA;
            }
        }

        return t1;
    }
}
