    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Stack;

    public class HJ50 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null) {
                int n = s.length();
                int num1 = 0, o1 = 1, num2 = 1, o2 = 1;
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (Character.isDigit(c)) {
                        int cur = 0;
                        while (i < n && Character.isDigit(s.charAt(i))) {
                            cur = cur*10 + s.charAt(i) - '0';
                            i++;
                        }
                        i--;
                        num2 = o2 == 1 ? num2 * cur : num2 / cur;

                    } else if (c == '*' || c == '/') {
                        o2 = c == '*' ? 1 : -1;
                    } else if (c == '{' || c == '[' || c == '(') {
                        stack.push(num1);
                        stack.push(o1);
                        stack.push(num2);
                        stack.push(o2);
                        num1 = 0; o1 = 1; num2 = 1; o2 = 1;
                    } else if (c == '+' || c == '-') {
                        if (c == '-' && (i == 0 || s.charAt(i-1) == '{' ||
                                s.charAt(i-1) == '[' || s.charAt(i-1) =='(')) {
                            o1 = -1;
                            continue;
                        }
                        num1 = num1 + o1 * num2;
                        o1 = c == '+' ? 1 : -1;
                        num2 = 1;
                        o2 = 1;
                    } else {
                        int cur = num1 + o1*num2;
                        o2 = stack.pop();
                        num2 = stack.pop();
                        o1 = stack.pop();
                        num1 = stack.pop();
                        if (cur != 0)
                            num2 = o2 == 1 ? num2*cur : num2/cur;
                    }
                }
                System.out.println(num1 + o1*num2);
            }
        }
    }
