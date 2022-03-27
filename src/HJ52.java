import java.io.IOException;
import java.util.Scanner;

public class HJ52 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            int[][] dp = new int[str1.length()+1][str2.length()+1];
            dp[0][0] = 0;
            for (int i= 1; i< dp.length; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i<dp[0].length; i++) {
                dp[0][i] = i;
            }
            for (int i= 1; i< dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (str1.charAt(i-1) == str2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
                    }
                }
            }
            System.out.println(dp[str1.length()][str2.length()]);
        }
    }
}
