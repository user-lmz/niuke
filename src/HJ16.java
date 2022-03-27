import java.util.Scanner;

public class HJ16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt() / 10;
        int num = in.nextInt();
        int[][] price = new int[num + 1][3];
        int[][] weight = new int[num + 1][3];
        for (int i = 1; i <= num; i++) {
            int v = in.nextInt() / 10;
            int p = in.nextInt();
            int q = in.nextInt();
            int w = v * p;

            if (q == 0) {
                price[i][0] = v;
                weight[i][0] = w;
            } else {
                if (price[q][1] == 0) {
                    price[q][1] = v;
                    weight[q][1] = w;
                } else {
                    price[q][2] = v;
                    weight[q][2] = w;
                }
            }
        }
        int[] dp = new int[money + 1];
        for (int i = 1; i <= num; i++) {
            if (price[i][0] == 0)
                continue;
            for (int j = money; j >= price[i][0]; j--) {
                int a = price[i][0];
                int a1 = weight[i][0];
                int b = price[i][1];
                int b1 = weight[i][1];
                int c = price[i][2];
                int c1 = weight[i][2];
                if (j >= a)
                    dp[j] = Math.max(dp[j], dp[j - a] + a1);
                if (j >= a + b)
                    dp[j] = Math.max(dp[j], dp[j - a - b] + a1 + b1);
                if (j >= a + c)
                    dp[j] = Math.max(dp[j], dp[j - a - c] + a1 + c1);
                if (j >= a + b + c)
                    dp[j] = Math.max(dp[j], dp[j - a - b - c] + a1 + b1 + c1);
            }
        }
        System.out.println(dp[money] * 10);
    }
}