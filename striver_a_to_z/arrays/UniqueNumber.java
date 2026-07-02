/**
 * XOR
 * Time: O(n)
 * Space: O(1)
 */
public class UniqueNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
            // XOR-ing consecutive & 1^1 & 0^0 = 0 (same eles on XORing gives 0)
            // 0 ^ 1 = 1 (dissimilar give 1 = the dissimilar/unique ele.)
        }

        return xor;
    }
}
