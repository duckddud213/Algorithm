import java.io.*;
import java.util.*;

public class boj10159 {
    static int N, M, cnt;
    static int INF = 1000000;
    static boolean isComparable;
    static int dist[][];
    static StringBuilder sb;

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
            cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j && dist[i][j] == INF && dist[j][i] == INF) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cnt = 0;

        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            dist[src][dest] = 1;
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        FloydWrasahll();
        System.out.println(sb);
    }
}
