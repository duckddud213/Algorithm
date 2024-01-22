import java.io.*;
import java.util.*;

public class boj11066 {
    static int x, T, K, gap;
    static int sum[], dp[][];
    static StringBuilder sb;

    public static void dynamic() {
        //dp[i][j] = min(dp[i][[i+k]+dp[i+k+1][j]), 0<=k<=j-i-1

        for (gap = 1; gap < K; gap++) {
            for (int src = 1; src + gap <= K; src++) {
                int dest = src + gap;
                dp[src][dest] = Integer.MAX_VALUE;

                for (int m = src; m < dest; m++) {
                    dp[src][dest] = Integer.min(dp[src][dest], dp[src][m] + dp[m + 1][dest] + sum[dest] - sum[src - 1]);
                }
            }
        }

        sb.append(dp[1][K]).append('\n');
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int x = 0; x < T; x++) {
            K = Integer.parseInt(br.readLine());
            sum = new int[K + 1];
            dp = new int[K + 1][K + 1];
            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= K; i++) {
                int num = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + num;
            }
            dynamic();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
