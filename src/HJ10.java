import java.util.BitSet;
import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        BitSet bs = new BitSet();
        for (char c: line.toCharArray()) {
            if (!bs.get(c)) {
                bs.set(c);
            }
        }
        System.out.println(bs.cardinality());
    }
}
