import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HJ69 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            int x = Integer.parseInt(str);
            int y = Integer.parseInt(br.readLine());
            int z = Integer.parseInt(br.readLine());
            int[][] matrix1 = new int[x][y];
            int[][] matrix2 = new int[y][z];
            for (int i=0; i<x; i++) {
                String[] param = br.readLine().split(" ");
                for (int j=0; j<y; j++) {
                    matrix1[i][j] = Integer.parseInt(param[j]);
                }
            }
            for (int i=0; i<y; i++) {
                String[] param = br.readLine().split(" ");
                for (int j=0; j<z; j++) {
                    matrix2[i][j] = Integer.parseInt(param[j]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<x; i++) {
                for (int j=0; j<z; j++) {
                    int sum = 0;
                    for (int k=0; k<y; k++) {
                        sum += matrix1[i][k]*matrix2[k][j];
                    }
                    sb.append(sum).append(" ");
                }
                sb.deleteCharAt(sb.length()-1).append("\n");
            }
            System.out.println(sb.toString());
        }
    }
}
