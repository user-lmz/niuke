import java.util.Scanner;

public class HJ57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            System.out.println(sum(s1, s2));
        }
    }

    private static String sum(String s1, String s2) {
        int m = s1.length()-1;
        int n = s2.length()-1;
        int res = 0;
        StringBuilder sb = new StringBuilder();
        while (m>=0 ||  n>=0) {
            char c1 = m >= 0? s1.charAt(m--) : '0';
            char c2 = n >= 0? s2.charAt(n--) : '0';
            int sum = (c1 - '0')+(c2 - '0') + res;
            sb.append(sum % 10);
            res = sum / 10;
        }
        if (res == 1) {
            sb.append(res);
        }
        return sb.reverse().toString();
    }
}
