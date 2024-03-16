import java.io.*;
import java.util.*;

public class boj15989 {
    static int x, T, N;
    static int dp[][];
    static StringBuilder sb;

    public static void dynamic() {
        if (N == 1) {
            sb.append(1).append('\n');
        }
        else if (N == 2) {
            sb.append(2).append('\n');
        }
        else if (N == 3) {
            sb.append(3).append('\n');
        }
        else {
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[3][1] = 1;
            dp[2][2] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;

            for (int i = 4; i <= N; i++) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            }

            int sum = dp[N][1]+dp[N][2]+dp[N][3];
            sb.append(sum).append('\n');
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int x = 1; x <= T; x++) {
            N = Integer.parseInt(br.readLine());

            dp = new int[N + 1][4];

            dynamic();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
