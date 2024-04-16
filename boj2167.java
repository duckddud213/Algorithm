import java.io.*;
import java.util.*;

public class boj2167 {
    static int N, M, K;
    static int arr[][], presum[][];
    static StringBuilder sb;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        presum = new int[N + 1][M + 1];
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        presum[1][1] = arr[1][1];
        for (int i = 2; i <= N; i++) {
            presum[i][1] = presum[i - 1][1] + arr[i][1];
        }

        for (int i = 2; i <= M; i++) {
            presum[1][i] = presum[1][i - 1] + arr[1][i];
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= M; j++) {
                presum[i][j] = presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1] + arr[i][j];
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int num = presum[c][d] - presum[c][b - 1] - presum[a - 1][d] + presum[a - 1][b - 1];
            sb.append(num).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
