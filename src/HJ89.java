import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ89 {
    private static final String[] ops = new String[]{"+", "-", "*", "/"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine())!= null && !"".equals(str)) {
            String[] ss = str.split(" ");
            int a = getNum(ss[0]);
            int b = getNum(ss[1]);
            int c = getNum(ss[2]);
            int d = getNum(ss[3]);
            if (a == -1 || b == -1 || c == -1 || d == -1) {
                System.out.println("ERROR");
                continue;
            }
            compute(a, b, c, d);
        }
        br.close();
    }

    private static void compute(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        String[][] arr1 = symbol();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int p = 0; p < 4; p++) {
                        if (i != j && i != k && i != p &&
                                j != k && j != p && k != p) {
                            for (String[] str: arr1) {
                                int num = sumNum(arr[i], arr[j], str[0]);
                                num = sumNum(num, arr[k], str[1]);
                                num = sumNum(num, arr[p], str[2]);
                                if (num == 24) {
                                    String result = change(arr[i])+str[0]+change(arr[j])+str[1]+
                                            change(arr[k])+str[2]+change(arr[p])+"";
                                    System.out.println(result);
                                    return;
                                }
                            }

                        }
                    }
                }
            }
        }
        System.out.println("NONE");
    }

    private static String change(int i) {
        switch (i) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return String.valueOf(i);
        }
    }

    private static int sumNum(int a, int b, String s) {
        switch (s){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 0;
        }
    }

    private static String[][] symbol() {
        int p = 0;
        String[][] symbol = new String[64][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                   symbol[p++] = new String[] {ops[i], ops[j], ops[k]};
                }
            }
        }
        return symbol;
    }

    private static int getNum(String s) {
        switch (s.toUpperCase()) {
            case "A":
                return 1;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "JOKER":
                return -1;
            default:
                return Integer.parseInt(s);
        }
    }
}
