
public class Palindrome {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public boolean isPalindrome1(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            char ch = Character.toLowerCase(c);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }
        }

        String cleaned = sb.toString();
        String reversed = sb.reverse().toString();

        return cleaned.equals(reversed);
    }

    /**
     * Time: O(n)
     * Space: O(1)
     */
    public boolean isPalindrome2(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int start = 0, end = s.length() - 1;
        while (start <= end) {
            char currFirst = s.charAt(start);
            char currEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currEnd)) {
                end--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currEnd)) {
                    return false;
                }

                start++;
                end--;
            }
        }

        return true;
    }
}
