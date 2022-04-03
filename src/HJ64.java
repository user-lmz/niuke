import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ64 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            char[] array = br.readLine().toCharArray();
            int current = 1;
            int start = 1;
            StringBuilder sr = new StringBuilder();
            for (char c: array) {
                if (num <= 4) {
                    if (c == 'U') {
                        if (current == 1)
                            current = num;
                        else
                            current--;
                    }
                    else if (c == 'D') {
                        if (current == num)
                            current = 1;
                        else
                            current++;
                    }
                } else {
                    if (c == 'U') {
                        if (current == 1) {
                            current = num;
                            start = current - 3;
                        }
                        else if (current == start) {
                            current--;
                            start--;
                        } else
                            current--;
                    }
                    else if (c == 'D') {
                        if (current == num) {
                            current = 1;
                            start = 1;
                        }
                        else if (current == start+3) {
                            current++;
                            start++;
                        } else
                            current++;
                    }
                }
            }
            for (int i=1; i<=4; i++) {
                if (num >= i)
                    sr.append(start + i - 1).append(" ");
            }
            System.out.println(sr.toString().trim());
            System.out.println(current);
        }
    }
}
