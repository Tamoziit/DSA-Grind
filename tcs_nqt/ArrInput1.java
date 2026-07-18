/**
 * Size of array given
 * Not comma separated
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrInput1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("List");
        n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}
