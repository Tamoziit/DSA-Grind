/**
 * Recursion & RLE
 * Time: O(n · 2^n)
 * Space: O(2^n)
 */
public class CountAndSay {

    public String countAndSay(int n) {
        String ans = "";

        while (n > 0) {
            ans = rle(ans);
            n--;
        }

        return ans;
    }

    private String rle(String s) {
        int n = s.length();
        String ans = "";

        if (n == 0) {
            return "1";
        }

        for (int i = 0; i < n; i++) {
            int count = 1;

            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }

            ans += Integer.toString(count);
            ans += s.charAt(i);
        }

        return ans;
    }
}
