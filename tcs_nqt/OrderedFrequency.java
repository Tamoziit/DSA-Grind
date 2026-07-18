
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OrderedFrequency {

    public void getOrderdedFreq(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        List<Character> order = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (freq.getOrDefault(ch, 0) == 0) {
                order.add(ch); // new ele
            }

            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : order) {
            int count = freq.get(ch);
            System.out.println(ch + " " + count);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderedFrequency ob = new OrderedFrequency();

        String s = sc.nextLine();
        ob.getOrderdedFreq(s);

        sc.close();
    }
}
