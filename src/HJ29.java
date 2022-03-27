import java.util.Scanner;

public class HJ29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(encode(sc.nextLine()));
            System.out.println(decode(sc.nextLine()));
        }
    }

    private static String encode(String code) {
        char[] t = code.toCharArray();
        for (int i=0; i<t.length; i++) {
            if (t[i] >= 'a' && t[i] < 'z')
                t[i] = (char) (t[i]-'a'+'A'+1);
            else if (t[i] == 'z')
                t[i] = 'A';
            else if (t[i] >= 'A' && t[i]<'Z')
                t[i] = (char) (t[i]-'A'+'a'+1);
            else if (t[i] == 'Z')
                t[i] = 'a';
            else if (t[i] >= '0' && t[i] < '9')
                t[i] = (char) (t[i]+1);
            else if (t[i] == '9')
                t[i] = '0';
        }
        return String.valueOf(t);
    }

    private static String decode(String password) {
        char[] t = password.toCharArray();
        for (int i=0; i<t.length; i++) {
            if (t[i] > 'a' && t[i] <= 'z')
                t[i] = (char) (t[i]-'a'+'A'-1);
            else if (t[i] == 'a')
                t[i] = 'Z';
            else if (t[i] > 'A' && t[i]<='Z')
                t[i] = (char) (t[i]-'A'+'a'-1);
            else if (t[i] == 'A')
                t[i] = 'z';
            else if (t[i] > '0' && t[i] <= '9')
                t[i] = (char) (t[i]-1);
            else if (t[i] == '0')
                t[i] = '9';
        }
        return String.valueOf(t);
    }
}
