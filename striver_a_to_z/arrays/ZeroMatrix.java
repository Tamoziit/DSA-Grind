public class ZeroMatrix {
    /**
     * Time: O(2(n * m))
     * Space: O(n + m)
     */
    public void setZeroes_better(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Time: O(2(n * m))
     * Space: O(1)
     */
    public void setZeroes_optimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // int[] row = new int[n]; --> matrix[][0]
        // int[] col = new int[m]; --> matrix[0][]
        int col0 = 1; // col[0] a new variable to avoid collision with row[0]

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // marking row

                    // marking column
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        // Transforming from (1, 1)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {
                    // checking row & col
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        // col[] - col0 transform
        if (matrix[0][0] == 0) {
            for (int j = 0; j < m; j++)
                matrix[0][j] = 0;
        }

        // row[] + col0 transform
        if (col0 == 0) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }
    }
}
