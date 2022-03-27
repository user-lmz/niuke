import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ75 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "";
        String str2 = "";
        while ((str1 = bf.readLine()) != null && (str2 = bf.readLine()) != null) {
            int max = 0;
            char[] ch1 = str1.toCharArray();
            char[] ch2 = str2.toCharArray();
            for (int i=0; i<ch1.length; i++) {
                for (int j=0; j<ch2.length; j++) {
                    int t1 = i;
                    int t2 = j;
                    int count = 0;
                    while (ch1[t1] == ch2[t2]) {
                        t1++;
                        t2++;
                        count++;
                        if (t1 == ch1.length || t2 == ch2.length) {
                            break;
                        }
                    }
                    max = Math.max(count, max);
                }
            }
            System.out.println(max);
        }
    }
}
