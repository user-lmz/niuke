import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ48 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int total = in.nextInt();
            int head = in.nextInt();
            List<Integer> linkedList = new ArrayList<>();
            linkedList.add(head);
            for (int i=0; i<total-1; i++) {
                int value = in.nextInt();
                int target = in.nextInt();
                linkedList.add(linkedList.indexOf(target)+1, value);
            }
            int remove = in.nextInt();
            linkedList.remove((Integer) remove);
            for (int i: linkedList) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
