import java.io.*;
import java.util.*;

public class boj10942 {
    static int N, M;
    static int num[];
    static boolean dp[][];
    static StringBuilder sb;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        num = new int[N + 1];
        dp = new boolean[N + 1][N + 1]; //dp[i][j] = i번째에서 j번째까지의 결과. 0 또는 1 저장

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = true;
        }

        for (int i = 1; i < N; i++) {
            if (num[i] == num[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        
        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (num[j] == num[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = true;
                }
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (dp[s][e]) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}