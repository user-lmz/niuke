import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        char ch = sc.nextLine().charAt(0);
        for (int i=0; i<str.length(); i++){
            if (str.charAt(i)==ch || Character.toUpperCase(str.charAt(i))==ch ||
                    Character.toLowerCase(str.charAt(i))==ch)
                count++;
        }
        System.out.println(count);
    }
}
