
public class ThirdMax {

    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE, secondMax = Long.MIN_VALUE, thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == firstMax || num == secondMax || num == thirdMax) {
                continue; // skipping duplicates
            }

            if (num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                thirdMax = num;
            }
        }

        return thirdMax != Long.MIN_VALUE ? (int) thirdMax : (int) firstMax;
    }
}
