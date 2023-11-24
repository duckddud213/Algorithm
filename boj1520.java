import java.io.*;
import java.util.*;

public class boj1520 {
    static int N, M;
    static int graph[][];
    static int dp[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static int DFS(int i, int j) {

        if (i == N - 1 && j == M - 1) {
            return 1;
        } 
        else if (dp[i][j] == -1) {
            dp[i][j] = 0;

            for (int idx = 0; idx < 4; idx++) {
                int qi = i + dx[idx];
                int qj = j + dy[idx];
                if (downSlope(i, j, qi, qj)) {
                    dp[i][j] += DFS(qi, qj);
                }
            }
        }

        return dp[i][j];
    }

    public static boolean downSlope(int i, int j, int ni, int nj) {
        if (ni < 0) {
            return false;
        }
        if (ni >= N) {
            return false;
        }
        if (nj < 0) {
            return false;
        }
        if (nj >= M) {
            return false;
        }

        if (graph[i][j] <= graph[ni][nj]) {
            return false;
        }

        return true;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N][M];
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(DFS(0, 0));
    }
}
