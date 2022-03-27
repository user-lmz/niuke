import java.util.Scanner;

public class HJ33 {
    private static final int N = 4;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String res = covert(str);
            System.out.println(res);
        }
    }

    private static String covert(String str) {
        if (str.contains(".")) {
            String[] stars = str.split("\\.");
            long result = 0;
            for (int i=0; i<N; i++) {
                result = result*256 + Integer.parseInt(stars[i]);
            }
            return result+"";
        } else {
            long num = Long.parseLong(str);
            StringBuilder result = new StringBuilder();
            for (int i=0; i<N; i++) {
                result.insert(0, num % 256 + ".");
                num /= 256;
            }
            return result.substring(0, result.length()-1);
        }
    }
}
