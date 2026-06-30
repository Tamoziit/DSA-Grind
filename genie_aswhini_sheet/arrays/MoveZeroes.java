
public class MoveZeroes {

    /**
     * 2-Pointer (My soln. - tracking start idx of contiguous zero-sequence)
     * Time: O(n)
     * Space: O(1)
     */
    public void moveZeroes_1(int[] nums) {
        int zptr = nums[0] == 0 ? 0 : -1; // initializing zero-ptr
        int temp;

        for (int i = 1; i < nums.length; i++) {
            if (zptr == -1 && nums[i] == 0) {
                zptr = i;
            }

            if (nums[i - 1] == 0 && nums[i] != 0) {
                temp = nums[zptr];
                nums[zptr] = nums[i];
                nums[i] = temp;

                zptr++; // starting zero-idx of contiguous zero-sequence after shifting non-zero eles. forward
            }
        }
    }

    /**
     * 2-Pointer (Cleaner Approach - tracking non-zero landing pos)
     * Time: O(n)
     * Space: O(1)
     */
    public void moveZeroes_2(int[] nums) {
        int insertPos = 0; // next index where a non-zero should land

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;

                insertPos++;
            }
        }
    }
}
