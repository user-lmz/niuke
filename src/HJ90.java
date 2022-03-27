import java.util.Scanner;

public class HJ90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String n = sc.nextLine();
            String[] s = n.split("\\.");
            if (s.length != 4) {
                System.out.println("NO");
            } else {
                String res = getRes(s);
                System.out.println(res);
            }
        }
    }

    private static String getRes(String[] s) {
        for (String item : s) {
            if ("".equals(item)) {
                return "NO";
            }
            int num = Integer.parseInt(item);
            if (num < 0 || num > 255) {
                return "NO";
            }
            for (int j = 0; j < item.length(); j++) {
                if (item.length() > 1 && item.charAt(0) == '0') {
                    return "NO";
                }
                if (!Character.isDigit(item.charAt(j))) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
