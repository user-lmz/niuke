import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HJ103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            int[] intArr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] k = new int[intArr.length];
            for (int j=1; j<intArr.length; j++) {
                for (int i = 0; i<j; i++) {
                    if (intArr[i] < intArr[j]) {
                        k[j] = Math.max(k[j], k[i]+1);
                    }
                }
            }
            Arrays.sort(k);
            System.out.println(k[k.length-1]+1);
        }
    }
}
