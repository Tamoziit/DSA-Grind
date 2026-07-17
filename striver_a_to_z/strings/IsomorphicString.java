/**
 * Hashmap + Set
 * Time: O(N)
 * Space: O(2N)
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(); // s -> t character map
        Set<Character> usedTargets = new HashSet<>(); // t -> s set to track for deduplication

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character mapped = map.getOrDefault(sc, null);

            if (mapped == null) { // new character in s->t map
                if (usedTargets.contains(tc)) {
                    return false; // tc already claimed by a different source char
                }
                map.put(sc, tc); // putting in s->t map
                usedTargets.add(tc); // putting in t->s set
            } else if (mapped != tc) { // mapping doesn't match
                return false;
            }
        }

        return true;
    }
}
