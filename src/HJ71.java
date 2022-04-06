import java.util.Scanner;

public class HJ71 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String p = in.nextLine().toLowerCase();
            String s = in.nextLine();
            int m = p.length();
            int n = s.length();
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for (int i = 1; i <= m; i++) {
                if (p.charAt(i-1) == '*') {
                    dp[i][0] = true;
                } else
                    break;
            }
            for (int i = 1; i <= m; i++) {
                char c1 = p.charAt(i-1);
                for (int j = 1; j <= n; j++) {
                    char c2 = s.charAt(j-1);
                    if (c1 == '*') {
                        if (check(c2))
                            dp[i][j] = dp[i-1][j] || dp[i][j-1];
                        else
                            dp[i][j] = false;
                    } else if (c1 == '?' || c1 == c2) {
                        if (check(c2))
                            dp[i][j] = dp[i-1][j-1];
                        else
                            dp[i][j] = false;
                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }

    private static boolean check(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z';
    }
}
