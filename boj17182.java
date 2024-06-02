import java.io.*;
import java.util.*;

public class boj17182 {
    static int N, K, result;
    static int dist[][];
    static boolean isVisited[];

    public static void backTracking(int src, int sum, int depth) {
        if (depth == N - 1) {
            result = Integer.min(result, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                backTracking(i, sum + dist[src][i], depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void FloydWrasahll() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    dist[i][j] = Integer.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        dist = new int[N][N];
        isVisited = new boolean[N];
        isVisited[K] = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        FloydWrasahll();
        backTracking(K, 0, 0);
        System.out.println(result);
    }
}
