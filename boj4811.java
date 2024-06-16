import java.io.*;
import java.util.*;

public class boj4811 {
    static int x, T, N;
    static long dp[];
    static StringBuilder sb;
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        dp = new long[31];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 30; i++) {
            long cnt = 0;

            for (int j = 0; j < i; j++) {
                cnt += dp[j] * dp[i - j - 1];
            }

            dp[i] = cnt;
        }

        N = Integer.parseInt(br.readLine());

        while (N != 0) {
            sb.append(dp[N]).append("\n");

            N = Integer.parseInt(br.readLine());
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
