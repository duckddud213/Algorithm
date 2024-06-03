import java.io.*;
import java.util.*;

public class boj11780 {
    static int N, M;
    static int INF = 10_000_000;
    static int dist[][];
    static List<Integer> route[][];
    static StringBuilder sb;

    public static void output() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
            }
            sb.append('\n');
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    sb.append("0").append('\n');
                    continue;
                }

                sb.append(route[i][j].size() + 2).append(" ").append(i).append(" ");
                for (int num : route[i][j]) {
                    sb.append(num).append(" ");
                }
                sb.append(j).append('\n');
            }
        }
    }

    public static void resetRoute(int i, int j, int k) {
        route[i][j].clear();
        for (int num : route[i][k]) {
            route[i][j].add(num);
        }
        route[i][j].add(k);
        for (int num : route[k][j]) {
            route[i][j].add(num);
        }
    }

    public static void FloydWrasahll() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        resetRoute(i, j, k);
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        route = new List[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
                route[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[src][dest] = Math.min(dist[src][dest], cost);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        FloydWrasahll();
        output();
        System.out.println(sb);
    }
}
