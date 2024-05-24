import java.io.*;
import java.util.*;

public class boj2458 {
    static int N, M, cnt;
    static int INF = 250000;
    static int dist[][];
    static boolean isComparable;

    public static void FloydWrasahll() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            isComparable = true;
            for (int j = 1; j <= N; j++) {
                if (i != j && dist[i][j] == INF && dist[j][i] == INF) {
                    isComparable = false;
                    break;
                }
            }

            if (isComparable) {
                cnt++;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            dist[src][dest] = 1;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        FloydWrasahll();
        System.out.println(cnt);
    }
}
