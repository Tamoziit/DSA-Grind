/**
 * Hashmap
 * Time: O(n.m); n = no. of strs, m = avg. length of each str.
 * Space: O(n)
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = getCharFreqKey(s);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String getCharFreqKey(String s) {
        int[] charFreq = new int[26];
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a']++;
        }

        char ch = 'a';
        for (int count : charFreq) {
            sb.append(ch);
            sb.append(count);
            ch++;
        }

        return sb.toString();
    }
}
