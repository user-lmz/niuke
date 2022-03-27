import java.util.Scanner;

public class HJ24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = 1;
            right[n-1] = 1;

            for (int i=0; i<n; i++) {
                left[i] = 1;
                for (int j=0; j<i; j++) {
                    if (arr[i] > arr[j]) {
                        left[i] = Math.max(left[j]+1, left[i]);
                    }
                }
            }
            for (int i=n-1; i>=0; i--) {
                right[i] = 1;
                for (int j=n-1; j>i; j--) {
                    if (arr[i] > arr[j]) {
                        right[i] = Math.max(right[i], right[j]+1);
                    }
                }
            }
            int[] results = new int[n];
            int max = 1;
            for (int i=0; i<n; i++) {
                results[i] = left[i] + right[i] - 1;
                max = Math.max(results[i], max);
            }
            System.out.println(n - max);
        }
    }
}
