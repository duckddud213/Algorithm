import java.io.*;
import java.util.*;

public class boj2839SecondTry {
    static int N, minBag;
    static int dp[];

    public static void countBag() {
        int i, j;

        if (N == 3 || N == 5) {
            minBag = 1;
            return;
        } else if (N < 5) {
            return;
        }

        dp[1] = N;
        dp[2] = N;
        dp[3] = 1;
        dp[4] = N;

        for (i = 5; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }
        if (dp[N] == N + 1) {
            dp[N] = -1;
        }
        minBag = dp[N];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        minBag = -1;
        countBag();

        System.out.println(minBag);
    }
}
