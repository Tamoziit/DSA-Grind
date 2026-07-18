
import java.util.Scanner;

public class StringInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // case 1: normal input - abc
        String s = sc.nextLine();
        System.out.println("String: " + s);

        //case 2: number before str, eg:
        // 1
        // abc
        int n = sc.nextInt();
        sc.nextLine(); // to consume \n or \t after nuo. input in cmd
        s = sc.nextLine();
        System.out.println(n + " " + s);

        // case 3: character input
        char ch = sc.next().charAt(0);
        System.out.println("Char = " + ch);

        sc.close();
    }
}
