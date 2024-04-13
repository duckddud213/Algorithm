import java.io.*;
import java.util.*;

public class boj12852 {
    static int N;
    static int dp[], trace[];
    static StringBuilder sb;
    public static void cal() {
        int num = N;

        for (int i = 0; i <= dp[N]; i++) {
            sb.append(num).append(" ");
            num = trace[num];
        }
    }

    public static void dynamic() {
        for (int i = 2; i <= N; i++) {
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                trace[i] = i / 3;
            }

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                trace[i] = i / 2;
            }

            if (i - 1 > 0 && dp[i] > dp[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                trace[i] = i - 1;
            }
        }

        sb.append(dp[N]).append('\n');
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        trace = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;

    }

    public static void main(String args[]) throws IOException {
        pre();
        dynamic();
        cal();
        System.out.println(sb);
    }
}
