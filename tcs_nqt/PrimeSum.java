
import java.util.Scanner;

public class PrimeSum {

    public int getPrimeSum(int n, int start) {
        int count = 0, nthPrime = 0, num = start;

        while (count < n) {
            if (isPrime(num)) {
                count++;

                if (count == n) {
                    nthPrime = num;
                    System.out.println(nthPrime);
                    break;
                }
            }

            num++;
        }

        int sum = nthPrime, found = 0;
        num = nthPrime + 1;
        while (found < 2) {
            if (isPrime(num)) {
                System.out.println(num);
                sum += num;
                found++;
            }

            num++;
        }

        return sum;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrimeSum ob = new PrimeSum();

        int n = sc.nextInt();
        int start = sc.nextInt();

        System.out.println("Sum = " + ob.getPrimeSum(n, start));

        sc.close();
    }
}
