import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bf.readLine())!=null) {
            String temp = input.substring(2, input.length());
            int sum = 0;
            int length = temp.length();
            for (int i=length-1; i>=0; i--) {
                char c = temp.charAt(i);
                int tempNumber = (int) c;
                if (tempNumber >= 65) {
                    tempNumber = tempNumber - 65 + 10;
                }else {
                    tempNumber = tempNumber - 48;
                }
                sum = sum + (int) Math.pow(16, length-i-1)*tempNumber;
            }
            System.out.println(sum);
        }
    }
}
