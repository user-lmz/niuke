import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class HJ19 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str;
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        while ((str = buffer.readLine())!=null && !str.equals("")) {
            int ind1 = str.lastIndexOf(" ");
            int ind2 = str.lastIndexOf("\\");
            String key = (ind1 - ind2) <= 16 ? str.substring(ind2+1) : str.substring(ind1-16);
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        buffer.close();
        int count = 0;
        for (String s: map.keySet()){
            ++count;
            if (count > map.size()-8)
                System.out.println(s+" "+map.get(s));
        }
    }
}
