/**
 * Kadane's 2-DP algo [Dual Product]
 * Time: O(n)
 * Space: O(1)
 */
public class MaxProductSubarray {

    public int maxProduct(int[] nums) {
        // base case
        if (nums.length == 1) {
            return nums[0];
        }

        // Intution:
        // Since product behaves differently from sum, Kadane's 1-state algo won't work here - we need to track 2 product states - min & max prod till index i
        // It is so because - a very min. prod can become max by encountering a -ve number, while a very max. prod can become min by encountering the same -ve.
        // So, we keep memory of the worst possible prod, since it can become the best possible product on 'flip' by -ve number in the array.
        int maxProd = nums[0]; // to track the max possible product till index i
        int minProd = nums[0]; // to track the min possible product till index i
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) { // flip min & max prods. for -ve since min prod now becomes the largest prod.
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(num, maxProd * num); // maximizing best possible prod. for even better prod. [for possible better -> worse -> again better flip]
            minProd = Math.min(num, minProd * num); // minimizing worst possible prod. for even worse prod. [for potential worse -> best flip]

            result = Math.max(result, maxProd); // maximizing the final greedy ans.
        }

        return result;
    }
}
