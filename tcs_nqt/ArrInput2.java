
/**
 * Size of array given
 * Comma/Space separated
 * Bracket enclosed
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ArrInput2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // case 1: 1 2 3 4 5
        System.out.println("Space separated");
        String input1 = sc.nextLine();
        String[] arr1 = input1.split(" "); // space separated

        ArrayList<Integer> list1 = new ArrayList<>();

        for (String token : arr1) {
            int num = Integer.parseInt(token);
            list1.add(num);
        }

        for (int num : list1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // case 2: 1,2,3,4,5
        System.out.println("Comma separated");
        String input2 = sc.nextLine();
        String[] arr2 = input2.split(","); // comma separated

        ArrayList<Integer> list2 = new ArrayList<>();

        for (String token : arr2) {
            int num = Integer.parseInt(token);
            list2.add(num);
        }

        for (int num : list2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // case 3: [1,2,3,4,5]
        System.out.println("Bracket enclosed");
        String input3 = sc.nextLine();

        if (input3.startsWith("[") && input3.endsWith("]")) {
            input3 = input3.substring(1, input3.length() - 1);
        } // omitting the brackets
        String[] arr3 = input3.split(",");

        ArrayList<Integer> list3 = new ArrayList<>();

        for (String token : arr3) {
            int num = Integer.parseInt(token);
            list3.add(num);
        }

        for (int num : list3) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}
