/**
 * 90 deg. rotation (in-situ Transpose + Row-Reverse)
 * Time: O(2(n.m))
 * Spacee: O(1)
 */
public class RotateMatrixImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // in-situ transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int k = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = k;
            }
        }

        // in-situ row-reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int k = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = k;
            }
        }
    }
}
