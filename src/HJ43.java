import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ43 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }
            List<Pos> path = new ArrayList<>();
            dfs(map, 0, 0, path);
            for (Pos pos: path) {
                System.out.println("(" + pos.x + "," + pos.y + ")");
            }
        }
    }

    private static boolean dfs(int[][] map, int x, int y, List<Pos> path) {
        map[x][y] = 1;
        path.add(new Pos(x, y));
        if (x == map.length - 1 && y == map[x].length - 1) {
            return true;
        }
        if (x+1 < map.length && map[x+1][y] == 0) {
            if (dfs(map, x+1, y, path))
                return true;
        }
        if (y+1 < map[x].length && map[x][y+1] == 0) {
            if (dfs(map, x, y+1, path))
                return true;
        }
        if (x-1 > -1 && map[x-1][y] == 0) {
            if (dfs(map, x-1, y, path))
                return true;
        }
        if (y-1 > -1 && map[x][y-1] == 0) {
            if (dfs(map, x, y-1, path))
                return true;
        }
        path.remove(path.size()-1);
        map[x][y] = 0;
        return false;
    }

    private static class Pos {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
