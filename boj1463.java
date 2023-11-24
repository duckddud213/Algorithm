import java.io.*;
import java.util.*;

public class boj1463 {
    static int N;
    static int dp[];

    public static void DP() {
        int i;

        Arrays.fill(dp, N);

        dp[1] = 0;

        while (dp[N] == N) {
            for (i = 1; i <= N; i++) {
                if (i + 1 <= N) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
                }
                if (i * 2 <= N) {
                    dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
                }
                if (i * 3 <= N) {
                    dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        DP();
        System.out.println(dp[N]);
    }
}
