import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ59 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while ((str = br.readLine()) != null) {
            int signal = 0;
            for (int i = 0; i<str.length(); i++) {
                if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                    System.out.println(str.charAt(i));
                    signal = 1;
                    break;
                }
            }
            if (signal == 0) {
                System.out.println(-1);
            }
        }
    }
}
