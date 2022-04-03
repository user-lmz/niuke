import java.util.*;

public class HJ66 {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        map.put("noMatch", "unknown command");
        Set<String[]> set = new HashSet<>();
        for (String s:map.keySet()) {
            set.add(s.split(" "));
        }
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String[] strs = in.nextLine().split(" ");
            String res = "noMatch";
            int count = 0;
            for (String[] s: set) {
                if (strs.length == 1) {
                    if (s.length == 2)
                        continue;
                    else {
                        if(s[0].startsWith(strs[0]))
                            res = s[0];
                    }
                }
                if (strs.length == 2) {
                    if (s.length == 1)
                        continue;
                    else {
                        if (s[0].startsWith(strs[0]) && s[1].startsWith(strs[1])) {
                            res = s[0] + " " + s[1];
                            count++;
                        }
                    }
                }
            }
            System.out.println(count > 1?"unknown command":map.get(res));
        }
    }
}
