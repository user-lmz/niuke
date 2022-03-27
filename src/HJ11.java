import java.util.Scanner;

public class HJ11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long num = sc.nextLong();
            StringBuilder sb = new StringBuilder(Long.toString(num));
            sb.reverse();
            System.out.println(sb.toString());
        }
    }
}
