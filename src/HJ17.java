import java.io.IOException;
import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] str = sc.nextLine().split(";");
            int x = 0, y = 0;
            for (String s: str) {
                if (!s.matches("[WASD][0-9]{1,2}")) {
                    continue;
                }
                int val = Integer.parseInt(s.substring(1));
                switch (s.charAt(0)) {
                    case 'W':
                        y += val;
                        break;
                    case 'A':
                        x -= val;
                        break;
                    case 'S':
                        y -= val;
                        break;
                    case 'D':
                        x += val;
                        break;
                }
            }
            System.out.printf("(%d, %d)\n", x, y);
        }

    }
}
