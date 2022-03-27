import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ65 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            String ss = br.readLine();
            if (str.length() < ss.length()) {
                System.out.println(res(str, ss));
            }else {
                System.out.println(res(ss, str));
            }
        }
    }

    private static String res(String s, String c) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = c.toCharArray();
        int[][] ins = new int[ch1.length+1][ch2.length+1];
        int max = 0;
        int start = 0;
        for (int i = 0; i< ch1.length; i++) {
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    ins[i+1][j+1] = ins[i][j] + 1;
                }
                if (ins[i+1][j+1] > max) {
                    max = ins[i + 1][j + 1];
                    start = i - max;
                }
            }
        }
        return s.substring(start+1, start+max+1);
    }
}
