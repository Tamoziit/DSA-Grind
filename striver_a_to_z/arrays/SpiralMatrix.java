/**
 * Simulation
 * Time: O(n * m)
 * Space: O(n * m)
 */
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        int left = 0, right = m - 1;
        int top = 0, bottom = n - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) { //farthest right
                res.add(matrix[top][i]);
            }
            top++; //down

            for (int i = top; i <= bottom; i++) { // farthest down
                res.add(matrix[i][right]);
            }
            right--; // left

            if (top <= bottom) {
                for (int i = right; i >= left; i--) { // farthest left
                    res.add(matrix[bottom][i]);
                }
                bottom--; // up
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) { // farthest top
                    res.add(matrix[i][left]);
                }
                left++; // right
            }
        }

        return res;
    }
}
