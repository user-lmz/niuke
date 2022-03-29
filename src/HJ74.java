import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ74 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            char[] chars = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int flag = 0;
            for (char aChar : chars) {
                if (aChar == '\"') {
                    flag++;
                    continue;
                }
                if (aChar != ' ') {
                    sb.append(aChar);
                } else {
                    if (flag % 2 != 0)
                        sb.append(aChar);
                    else {
                        sb.append("\n");
                        count++;
                    }
                }
            }
            System.out.println(count + "\n" + sb);
        }
    }
}
