import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class HJ77 {
    static ArrayList<String> l = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = in.readLine()) != null) {
            int n = Integer.parseInt(str);
            int[] nums = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Stack<Integer> stack = new Stack<>();
            trainOut(nums, 0, stack, "", 0);
            Collections.sort(l);
            for (String s: l) {
                System.out.println(s);
            }
        }
    }

    private static void trainOut(int[] nums, int i, Stack<Integer> stack, String str, int n) {
        if (n == nums.length)
            l.add(str);
        if (!stack.isEmpty()) {
            int tmp = stack.pop();
            trainOut(nums, i, stack, str+tmp+" ", n+1);
            stack.push(tmp);
        }
        if (i<nums.length) {
            stack.push(nums[i]);
            trainOut(nums, i+1, stack, str, n);
            stack.pop();
        }

    }
}
