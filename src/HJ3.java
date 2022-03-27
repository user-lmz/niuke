import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class HJ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        TreeSet set = new TreeSet();
        for (int i=0; i < num; i++){
            set.add(sc.nextInt());
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}