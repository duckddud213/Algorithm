import java.io.*;
import java.util.*;

public class boj1562 {
    static int N, i, j, k, bit;
    static long MOD, sum;
    static long dp[][][];

    public static void stairNum() {
        for (i = 2; i < N + 1; i++) {
            for (j = 0; j < 10; j++) {
                for (k = 0; k < 1024; k++) {
                    bit = k | (1 << j);
                    if (j != 0 && j != 9) {
                        dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % MOD;
                    } else {
                        if (j == 0) {
                            dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % MOD;
                        } else {
                            dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % MOD;
                        }
                    }
                }
            }
        }

        for (i = 0; i < 10; i++) {
            sum += dp[N][i][1023] % MOD;
            sum %= MOD;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MOD = 1000000000;
        sum = 0;

        dp = new long[N + 1][11][1 << 10];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        stairNum();
        System.out.println(sum);
    }
}
