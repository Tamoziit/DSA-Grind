
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return new int[0];
        }

        int[] arrCpy = Arrays.copyOf(arr, n);
        Arrays.sort(arrCpy);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1, lastSeen = arrCpy[0];
        map.put(arrCpy[0], rank);

        for (int i = 1; i < n; i++) {
            if (arrCpy[i] != lastSeen) {
                rank++;
                map.put(arrCpy[i], rank);
                lastSeen = arrCpy[i];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
