import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ20 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;

        while ((input = reader.readLine()) != null) {
            //长度超过8位
            if (input.length() < 9) {
                System.out.println("NG");
                continue;
            }
            //包括大小写字母.数字.其它符号,以上四种至少三种
            boolean[] flag = new boolean[4];
            char[] chs = input.toCharArray();
            for (char c : chs) {
                if (c >= '0' && c <= '9') {
                    flag[0] = true;
                } else if (c >= 'a' && c <= 'z') {
                    flag[1] = true;
                } else if (c >= 'A' && c <= 'Z') {
                    flag[2] = true;
                } else {
                    flag[3] = true;
                }
            }
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (flag[i]) {
                    count++;
                }
            }

            //不能有长度大于2的不含公共元素的子串重复
            boolean sign = true;
            int length = chs.length;
            for (int i = 0; i < length - 5; i++) {
                for (int j = i + 3; j < length - 2; j++) {
                    if (chs[i] == chs[j] && chs[i + 1] == chs[j + 1]
                            && chs[i + 2] == chs[j + 2]) {
                        sign = false;
                        break;
                    }
                }
            }

            if (count >= 3 && sign)
                System.out.println("OK");
            else
                System.out.println("NG");
        }
        reader.close();

    }
}
