import java.io.*;
import java.util.*;

public class boj11265 {
    static int N, M, A, B, C;
    static int dist[][];
    static StringBuilder sb;

    public static void FLoydWrasahll() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        FLoydWrasahll();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sb.append(dist[A][B] <= C ? "Enjoy other party" : "Stay here").append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
