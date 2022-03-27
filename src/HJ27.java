import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HJ27 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null && !str.equals("")) {
            String[] ss = str.split(" ");
            int a = Integer.parseInt(ss[0]);
            String x = ss[ss.length-2];
            int k = Integer.parseInt(ss[ss.length-1]);
            List<String> list = new ArrayList<>();

            for (int i=1; i<=a; i++) {
                if (isBrother(x, ss[i])) {
                    list.add(ss[i]);
                }
            }
            int size = list.size();
            System.out.println(size);
            if (size >= k) {
                Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
                System.out.println(list.get(k-1));
            }
        }
    }

    private static boolean isBrother(String x, String y) {
        if (x.length() != y.length() || x.equals(y)) {
            return false;
        }
        char[] a = x.toCharArray();
        char[] b = y.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return new String(a).equals(new String(b));
    }
}
