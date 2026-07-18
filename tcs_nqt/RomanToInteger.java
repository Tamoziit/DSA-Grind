
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);

            if (i != 0) {
                char prev = s.charAt(i - 1);
                if ((prev == 'I' && (curr == 'V' || curr == 'X'))
                        || (prev == 'X' && (curr == 'L' || curr == 'C'))
                        || (prev == 'C' && (curr == 'D' || curr == 'M'))) {
                    res += map.get(curr) - map.get(prev);
                    i -= 1;
                } else {
                    res += map.get(curr);
                }
            } else {
                res += map.get(curr);
            }
        }

        return res;
    }
}
