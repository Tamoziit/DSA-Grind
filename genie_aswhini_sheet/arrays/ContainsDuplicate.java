
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int count = map.merge(nums[i], 1, Integer::sum);

            if (count > 1) {
                return true; // duplicate detected
            }
        }

        return false;
    }
}
