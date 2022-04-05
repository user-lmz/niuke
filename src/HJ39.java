import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ39 {
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mask;
        while ((mask = br.readLine()) != null && mask.length()!=0) {
            String ip1 = br.readLine();
            String ip2 = br.readLine();
            check(mask, ip1, ip2);
        }
        br.close();
        System.out.println(sb.toString());
    }

    private static void check(String mask, String ip1, String ip2) {
        boolean codeMask = checkFormat(mask);
        boolean codeIp1 = checkFormatIP(ip1);
        boolean codeIp2 = checkFormatIP(ip2);
        if (!codeMask || !codeIp1 || !codeIp2) {
            sb.append(1).append('\n');
            return;
        }
        long maskNum = ip2num(mask);
        long ip1Num = ip2num(ip1);
        long ip2Num = ip2num(ip2);
        if ((maskNum & ip1Num) == (maskNum & ip2Num)) {
            sb.append(0).append('\n');
            return;
        }
        sb.append(2).append('\n');
    }

    private static long ip2num(String str) {
        String[] ss = str.split("\\.");
        long sum = 0;
        long mul = 1;
        for (int i = ss.length - 1; i >= 0; i--) {
            sum += Integer.parseInt(ss[i]) * mul;
            mul *= 256;
        }
        return sum;
    }

    private static boolean checkFormatIP(String str) {
        String[] ss = str.split("\\.");
        for (String s: ss) {
            int num = Integer.parseInt(s);
            if (!(num >= 0 && num <= 255)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkFormat(String mask) {
        String[] ss = mask.split("\\.");
        int[] m = new int[ss.length];
        for (int i=0; i<ss.length; i++) {
            m[i] = Integer.parseInt(ss[i]);
        }
        return m[0] >= 0 && m[0] <= 255 &&
                m[1] >= 0 && m[1] <= 255 &&
                m[2] >= 0 && m[2] <= 255 &&
                m[3] >= 0 && m[3] <= 255 &&
                m[0] >= m[1] && m[1] >= m[2] && m[2] >= m[3];
    }
}
