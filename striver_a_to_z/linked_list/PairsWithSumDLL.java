/**
 * HashMap
 * Time: O(N)
 * Space: O(N)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode {

    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

public class PairsWithSumDLL {

    public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head;

        while (curr != null) {
            if (map.getOrDefault(target - curr.val, -1) != -1) {
                List<Integer> list = new ArrayList<>();
                list.add(target - curr.val);
                list.add(curr.val);

                res.add(list);
            }

            map.put(curr.val, 1);
            curr = curr.next;
        }

        // sort pairs by first element ascending
        res.sort((a, b) -> a.get(0) - b.get(0));

        return res;
    }
}
