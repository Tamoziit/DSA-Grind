/**
 * Time: O(2[NlgN + N])
 * Space: O(1) [without the auxiliary default sorting space]
 */
import java.util.Arrays;

public class MinPlatforms {

    public int minPlatform(int arr[], int dep[]) {
        // greedy step: sorting arrival & departure as time-series such that, the min. no. of platforms required to accomodate all trains can be determined at a given instance.
        // this happens to be like normal human perception of time & scheduling where, we allocate a platform Pi to train Ti, and in the same time if another train Tj arrives we assign it platform Pj, else Pi.
        Arrays.sort(arr);
        Arrays.sort(dep);

        int count = 0, maxCount = 0;
        int i = 0; // arrival ptr
        int j = 0; // departure ptr

        while (i < arr.length) { // while there are still trains to arrive
            if (arr[i] <= dep[j]) { // arrival: arrival before departure of prev. train
                count++;
                i++;
            } else { // departure of train frees up a platform
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
        }

        // min. platforms req. to accomodate all trains at any instance = max. collisions at that instance
        return maxCount;
    }
}
