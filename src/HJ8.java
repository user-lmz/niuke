import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tableSize = Integer.parseInt(bf.readLine());
        Map<Integer, Integer> table = new HashMap<>(tableSize);
        for (int i=0; i<tableSize; i++) {
            String[] val = bf.readLine().split(" ");
            int key = Integer.parseInt(val[0]);
            int value = Integer.parseInt(val[1]);
            if (table.containsKey(key)) {
                table.put(key, table.get(key)+value);
            } else {
                table.put(key, value);
            }
        }
        for (Integer key: table.keySet()) {
            System.out.println(key + " " + table.get(key));
        }
    }
}
