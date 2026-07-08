/**
 * Simulation
 * Time: O(N)
 * Space: O(N)
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < numRows; r++) {
            int increment = (numRows - 1) * 2; // default for row = 0, n - 1

            for (int i = r; i < n; i += increment) {
                sb.append(s.charAt(i)); // curr. char
                int jump = i + increment - 2 * r; // (n - 1) * 2 - 2 * r

                if (r > 0 && r < numRows - 1 && jump < n) { // intermediate rows --> default jump not applicable
                    sb.append(s.charAt(jump));
                } // if not intermediate --> go back to default jump after end of loop
            }
        }

        return sb.toString();
    }
}
