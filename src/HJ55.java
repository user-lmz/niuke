import java.util.Scanner;

public class HJ55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for (int i=1; i<=n; i++) {
            if (i%7 == 0) {
                count++;
            }else {
                String s = String.valueOf(i);
                if (s.contains("7"))
                    count++;
            }
        }
        System.out.println(count);
    }
}
