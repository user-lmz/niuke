import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HJ26 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = bf.readLine()) != null && input.length() != 0) {
            String res = sort(input);
            System.out.println(res);
        }
    }

    private static String sort(String input) {
        List<Character> letters = new ArrayList<>();
        for (char c: input.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }

        letters.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });

        StringBuilder result = new StringBuilder();
        for (int i=0, j=0; i<input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                result.append(letters.get(j++));
            }
            else {
                result.append(input.charAt(i));
            }
        }
        return result.toString();
    }
}
