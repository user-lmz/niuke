import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ32 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = bf.readLine()) != null && s.length() != 0) {
            System.out.println(solution(s));
        }
        bf.close();
    }

    private static int solution(String s) {
        int res = 0;
        for (int i=0; i<s.length(); i++) {
            int len1 = longest(s, i, i);
            int len2 = longest(s, i, i+1);
            res = Math.max(res, Math.max(len1, len2));
        }
        return res;
    }

    private static int longest(String s, int l, int r) {
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
