/**
 * Recursion
 * Time: O(lg n)
 * Space: O(1)
 */
public class Pow {

    public double myPow(double x, int n) {
        long N = n; // widening to long so negating INT_MIN doesn't overflow

        if (N < 0) {
            x = 1 / x; // reciprocal for -ve power
            N = -N; // turning -ve power to +ve after reciprocal
        }

        return fastPow(x, N);
    }

    // x ^ n = (x ^ (n/2)) ^ 2
    private double fastPow(double x, long n) {
        // base case
        if (n == 0) {
            return 1.0;
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) { // even power
            return half * half;
        } else { // odd power
            return half * half * x;
        }
    }
}
