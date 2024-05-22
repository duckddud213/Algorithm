import java.io.*;
import java.util.*;

public class boj1956 {
    static int V, E, result;
    static int INF = 4_000_001;
    static int dist[][];

    public static void FloydWrasahll() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        result = INF;
        for (int i = 1; i <= V; i++) {
            result = Math.min(result, dist[i][i]);
        }

        if (result == INF) {
            result = -1;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            dist[src][dest] = d;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        FloydWrasahll();
        System.out.println(result);
    }
}
