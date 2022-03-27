import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HJ21 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        char[] chs = bf.readLine().toCharArray();
        Map<String, Integer> map = new HashMap<>();
        map.put("abc", 2);
        map.put("def", 3);
        map.put("ghi", 4);
        map.put("jkl", 5);
        map.put("mno", 6);
        map.put("pqrs", 7);
        map.put("tuv", 8);
        map.put("wxyz", 9);
        StringBuilder sb = new StringBuilder();
        for (char c : chs) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Y') {
                sb.append((char) (Character.toLowerCase(c) + 1));
            } else if (c == 'Z') {
                sb.append('a');
            } else {
                Set<String> keys = map.keySet();
                for (String k : keys) {
                    if (k.contains(String.valueOf(c)))
                        sb.append(map.get(k));
                }
            }
        }
        System.out.println(sb.toString());

    }
}
