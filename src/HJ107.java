import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ107{
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        double input = Double.parseDouble(s);
        boolean flag = false;
        if (input < 0) {
            input = -input;
            flag = true;
        }

        double distance = input;
        double index = 0;
        double last;

        while (true) {
            last = index*index*index;
            if (last > input) {
                index -= distance;
                distance = distance/10;
            }
            if (distance < 0.001)
                break;
            index += distance;
        }

        double result = (int) (index+0.05)*10/10.0;
        if (flag)
            result = -result;
        System.out.println(result);
    }
}