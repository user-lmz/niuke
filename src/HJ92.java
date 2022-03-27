import java.io.*;

public class HJ92 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null && str.length() != 0) {
            char[] chars = str.toCharArray();
            int max=0;
            String res = null;
            for (int i=0; i<chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    int start = i;
                    while (i<chars.length && chars[i] >= '0' && chars[i] <= '9') {
                        i++;
                    }
                    int len = i-start;
                    if (len > max) {
                        max = len;
                        res = str.substring(start, i);
                    } else if (len == max) {
                        res = res + str.substring(start, i);
                    }
                }
            }
            sb.append(res).append(",").append(max).append('\n');
        }
        System.out.println(sb.toString());
    }
}
