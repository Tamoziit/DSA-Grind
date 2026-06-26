package genie_aswhini_sheet;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int k = 0, lastSeen = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastSeen) {
                nums[++k] = nums[i];
                lastSeen = nums[i];
            }
        }

        return (k + 1);
    }
}
