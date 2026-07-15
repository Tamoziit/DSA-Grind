/**
 * Time: O(N)
 * Space: O(N)
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {
        s = s.trim(); // remove leading & trailing spaces;
        s = s + " "; // adding a trailing space to account for the last word;

        String[] words = new String[s.length()]; // max possible words
        int wordCount = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            char curr = s.charAt(i);
            char next = s.charAt(i + 1);

            if (curr == ' ') {
                continue; // ignoring spaces
            }
            if (curr != ' ') { // character
                word.append(curr);
            }
            if (next == ' ' && curr != ' ') { // word completed
                words[wordCount] = word.toString(); // store word in array
                wordCount++;
                word.setLength(0); // reset word
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = wordCount - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }

        return res.toString();
    }
}
