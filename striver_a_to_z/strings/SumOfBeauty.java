/**
 * Rolling Frequency Array Technique
 * Time: O(N^2)
 * Space: O(26) [const]
 */
public class SumOfBeauty {

    public int beautySum(String s) {
        int n = s.length();
        int sumOfBeauty = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++; // incrementing the count of new char for each j increment of [i...j] substring

                sumOfBeauty += getMax(freq) - getMin(freq); // calculating beauty for each substring & adding it to the sum
            }
        }

        return sumOfBeauty;
    }

    private int getMin(int[] freq) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                min = Math.min(min, freq[i]);
            }
        }

        return min;
    }

    private int getMax(int[] freq) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                max = Math.max(max, freq[i]);
            }
        }

        return max;
    }
}
