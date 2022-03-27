import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = 0;
        for (int i=0; i<32; i++) {
            if ((num&1) == 1)
                n++;
            num >>>= 1;
        }
        System.out.println(n);
    }
}
