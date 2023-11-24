import java.io.*;
import java.util.*;

public class boj17626 {
    static int N;
    static int dp[];

    public static void doDP() {
        int i, j;

        if (N <= 3) {
            dp[N] = N;
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (i = 4; i <= N; i++) {
            dp[i] = i;

            if (Math.floor(Math.sqrt(i)) * Math.floor(Math.sqrt(i)) == i) {
                dp[i] = 1;
                continue;
            }

            for (j = 1; j <= (int) Math.sqrt(i); j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        doDP();

        System.out.println(dp[N]);
    }
}
