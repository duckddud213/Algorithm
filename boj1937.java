import java.io.*;
import java.util.*;

public class boj1937 {
    static int N, max;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int forest[][];
    static int dp[][];

    public static int dfs(Pos cur) {

        if (dp[cur.x][cur.y] != 0) {
            return dp[cur.x][cur.y];
        }

        dp[cur.x][cur.y] = 1;

        for (int idx = 0; idx < 4; idx++) {
            int x = cur.x + dx[idx];
            int y = cur.y + dy[idx];
            if (isValid(x, y) && forest[cur.x][cur.y] > forest[x][y]) {
                dp[cur.x][cur.y] = Integer.max(dp[cur.x][cur.y], dfs(new Pos(x, y)) + 1);
            }
        }

        return dp[cur.x][cur.y];
    }

    public static boolean isValid(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < N) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        max = 0;

        forest = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Integer.max(max, dfs(new Pos(i, j)));
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(max);
    }

    static class Pos {
        int x, y;

        public Pos() {
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
