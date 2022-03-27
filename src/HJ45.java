import java.util.Arrays;
import java.util.Scanner;

public class HJ45 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i =0; i<n; i++) {
                String str = in.next();
                int[] s = new int[128];
                for (int j=0; j<str.length(); j++) {
                    s[str.charAt(j)]++;
                }
                Arrays.sort(s);
                int mul=26, sum=0;
                for (int j=s.length-1; j>=0 && s[j]>0; j--) {
                    sum += mul*s[j];
                    mul--;
                }
                System.out.println(sum);
            }
        }
    }
}
