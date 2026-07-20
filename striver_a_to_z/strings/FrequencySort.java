/**
 * HashMap + Priority Queue
 * Time: O(n + k log k), where
 * - n = length of string
 * - k = no. of distinct eles.
 * Space: freq map [O(k)] + priority queue [O(k)] + String builder [O(n)]
 * so, total = O(n + k)
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) { // O(n)
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        ); // sorting keys by freq. in desc. order

        // populating the priority queue with keys
        pq.addAll(freq.entrySet()); // k entries take O(lg k) -> O(k lg k)

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) { // O(n)
            Map.Entry<Character, Integer> entry = pq.poll();
            res.append(String.valueOf(entry.getKey()).repeat(entry.getValue())); // building the string
        }

        return res.toString();
    }
}
