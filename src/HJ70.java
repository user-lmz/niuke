import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HJ70 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            int[][] arr = new int[num][2];
            for (int i = 0; i < num; i++) {
                String[] sa = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(sa[0]);
                arr[i][1] = Integer.parseInt(sa[1]);
            }
            int n = arr.length - 1;
            char[] ca = br.readLine().toCharArray();
            Stack<Integer> stack = new Stack<>();
            int sum = 0;
            for (int i = ca.length - 1; i >= 0; i--) {
                char one = ca[i];
                if (one == ')') {
                    stack.push(-1);
                } else if (one == '(') {
                    int n1 = stack.pop();
                    int n2 = stack.pop();
                    sum += arr[n1][0]*arr[n1][1]*arr[n2][1];
                    arr[n1][1] = arr[n2][1];
                    stack.pop();
                    stack.push(n1);
                } else {
                    stack.push(n);
                    n--;
                }
            }
            System.out.println(sum);
        }
    }
}
