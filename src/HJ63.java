import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ63 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(br.readLine());
            char[] chars = str.toCharArray();
            int count = 1;
            int max = 0;
            int left = 0;
            for (int i = 1; i<=chars.length-n; i++) {
                char pre = chars[i-1];
                char end = chars[i+n-1];
                if (pre == 'G' || pre == 'C')
                    count--;
                if (end == 'G' || end == 'C')
                    count++;
                if (count > max) {
                    max = count;
                    left = i;
                }
            }
            System.out.println(str.substring(left, left+n));
        }
    }
}
