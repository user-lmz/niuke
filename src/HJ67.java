import java.util.Arrays;
import java.util.Scanner;

public class HJ67 {
    public static int[] nums = new int[4];
    public static boolean[] visit = new boolean[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            for (int i=0; i< nums.length; i++) {
                nums[i] = sc.nextInt();
            }

            Arrays.fill(visit, true);
            System.out.println(dfs(0,0));
        }
    }

    private static boolean dfs(double res, int index) {
        if (index >= 4)
            return Math.abs(res - 24) == 0;
        boolean flag = false;
        for (int i=0; i<4; i++) {
            if (visit[i]) {
                visit[i] = false;
                flag = dfs(res+nums[i], index+1)
                        || dfs(res-nums[i], index+1)
                        || dfs(res*nums[i], index+1)
                        || dfs(res/nums[i], index+1);
                visit[i] = true;
                if (flag) {
//                    System.out.println("res: "+res);
//                    System.out.println("index: "+index);
                    break;
                }

            }
        }
        return flag;
    }
}
