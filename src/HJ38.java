import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ38 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            double h = Double.parseDouble(str);
            double temp = h/2;
            for (int i=1; i<5; i++) {
                h += temp*2;
                temp = temp/2;
            }
            System.out.println(h);
            System.out.println(temp);
        }
    }
}
