/**
 * Time: O(N)
 * Space: O(1) [const 3-idx array]
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int[] colors = new int[3];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            colors[nums[i]]++;
        }

        int x = 0;
        for (int i = 0; i < colors[0]; i++) {
            nums[x++] = 0;
        }
        for (int i = 0; i < colors[1]; i++) {
            nums[x++] = 1;
        }
        for (int i = 0; i < colors[2]; i++) {
            nums[x++] = 2;
        }
    }
}
