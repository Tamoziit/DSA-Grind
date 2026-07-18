
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BufferedReaderContingency {

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            // no. input
            System.out.println("Enter any no.");
            int n = Integer.parseInt(br.readLine());
            System.out.println("Number = " + n);

            // array input
            System.out.println("Enter array:");
            String input = br.readLine();
            if (input.startsWith("[") && input.endsWith("]")) {
                input = input.substring(1, input.length() - 1);
            }

            String[] arr = input.split(",");
            ArrayList<Integer> list = new ArrayList<>();

            for (String token : arr) {
                int num = Integer.parseInt(token);
                list.add(num);
            }

            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();

            // String input
            System.out.println("Enter no. & string");
            int a = Integer.parseInt(br.readLine());
            String s = br.readLine();

            System.out.println(a + " " + s);

            // character input
            System.out.println("Enter a character");
            char ch = (char) br.read();
            System.out.println("You entered: " + ch);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
