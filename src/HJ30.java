import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HJ30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine())!=null) {
            String[] sts = str.split(" ");
            String ss = sts[0]+sts[1];
            char[] chs = ss.toCharArray();
            for (int i=0; i < chs.length; i+=2) {
                for (int j=i+2; j < chs.length; j+=2) {
                    if (chs[i] > chs[j]) {
                        char t = chs[i];
                        chs[i] = chs[j];
                        chs[j] = t;
                    }
                }
            }
            for (int i=1; i < chs.length; i+=2) {
                for (int j=i+2; j < chs.length; j+=2) {
                    if (chs[i] > chs[j]) {
                        char t = chs[i];
                        chs[i] = chs[j];
                        chs[j] = t;
                    }
                }
            }
            Map<Character, Character> map = new HashMap<>(){
                {
                    put('0', '0');
                    put('1', '8');
                    put('2', '4');
                    put('3', 'C');
                    put('4', '2');
                    put('5', 'A');
                    put('6', '6');
                    put('7', 'E');
                    put('8', '1');
                    put('9', '9');
                    put('A', '5');
                    put('B', 'D');
                    put('C', '3');
                    put('D', 'B');
                    put('E', '7');
                    put('F', 'F');
                }
            };
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                if (c >= '0' && c <= '9' || c >= 'A' && c <= 'F') {
                    chs[i] = map.get(c);
                } else if (c >= 'a' && c <= 'f') {
                    chs[i] = map.get((char)(c-32));
                }
            }
            for (char c: chs)
                System.out.print(c);
        }
    }
}
