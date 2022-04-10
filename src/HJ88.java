import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ88 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split("-");
            System.out.println(helper(arr[0], arr[1]));
        }
    }

    private static String helper(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>(){
            {
                put("A", 14);
                put("2", 15);
                put("3", 3);
                put("4", 4);
                put("5", 5);
                put("6", 6);
                put("7", 7);
                put("8", 8);
                put("9", 9);
                put("10", 10);
                put("J", 11);
                put("Q", 12);
                put("K", 13);
                put("joker", 16);
                put("JOKER", 17);
            }
        };
        if (s1.equals("joker JOKER") || s1.equals("JOKER joker"))
            return s1;
        if (s2.equals("joker JOKER") || s2.equals("JOKER joker"))
            return s2;
        String[] a1 = s1.split(" ");
        int n1 = map.get(a1[0]);
        String[] a2 = s2.split(" ");
        int n2 = map.get(a2[0]);
        if (isBoom(s1) && isBoom(s2)) {
            return n1 > n2 ? s1 : s2;
        }
        else if (isBoom(s1))
            return s1;
        else if (isBoom(s2))
            return s2;
        else if (a1.length == a2.length)
            return n1 > n2 ? s1 : s2;
        else
            return "ERROR";
    }

    private static boolean isBoom(String a) {
        String[] temp = a.split(" ");
        if (temp.length != 4) return false;
        String cur = temp[0];
        for (int i=1; i< temp.length; i++) {
            if (!temp[i].equals(cur))
                return false;
        }
        return true;
    }
}
