import java.util.Scanner;

public class HJ16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt()/10;
            int m = in.nextInt();
            int[][] money = new int[m+1][3];
            int[][] weight = new int[m+1][3];
            for (int i = 1; i <= m; i++) {
                int v = in.nextInt()/10;
                int p = in.nextInt();
                int q = in.nextInt();
                int w = v*p;
                if (q == 0) {
                    money[i][0] = v;
                    weight[i][0] = w;
                } else {
                    if (money[q][1]==0) {
                        money[q][1] = v;
                        weight[q][1] = w;
                    } else if (money[q][2] == 0) {
                        money[q][2] = v;
                        weight[q][2] = w;
                    }
                }
            }
            int[] dp = new int[n+1];
            for (int i = 1; i <= m; i++) {
                if (money[i][0] == 0)
                    continue;
                for (int j = n; j >= money[i][0]; j--) {
                    int a = money[i][0];
                    int a1 = weight[i][0];
                    int b = money[i][1];
                    int b1 = weight[i][1];
                    int c = money[i][2];
                    int c1 = weight[i][2];
                    if (j >= a)
                        dp[j] = Math.max(dp[j], dp[j-a]+a1);
                    if (j >= a+b)
                        dp[j] = Math.max(dp[j], dp[j-a-b]+a1+b1);
                    if (j >= a+c)
                        dp[j] = Math.max(dp[j], dp[j-a-c]+a1+c1);
                    if (j >= a+b+c)
                        dp[j] = Math.max(dp[j], dp[j-a-b-c]+a1+b1+c1);
                }
            }
            System.out.println(dp[n]*10);
        }
    }
}

