/**
 * Hashmap with space optimization
 * Time: O(M + N)
 * Space: O(min(M, N))
 * M = len(nums1) [smaller], N = len(nums2) [larger]
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectingArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        // Ensuring nums1 is the smaller array (optional space optimization)
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // Building frequency map of smaller nums1
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Walking larger nums2, to check intersecting eles. & decrement
        List<Integer> intersectRes = new ArrayList<>();
        for (int num : nums2) {
            int count = freq.getOrDefault(num, 0);
            if (count > 0) {
                intersectRes.add(num);
                freq.put(num, count - 1); // decrementing so num is not reused
            }
        }

        int[] res = new int[intersectRes.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = intersectRes.get(i);
        }

        return res;
    }
}
