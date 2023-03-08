import java.util.Scanner;

public class boj2839 {
    public static int min(int a, int b) {
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static void main(String argsp[]) {
        int n, i, j;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int dp[] = new int[n + 1];

        for (i = 0; i < n + 1; i++) {
            dp[i] = n;
        }

        if (n >= 5) {
            for (i = 5; i <= n; i++) {
                if (i % 3 == 0) {
                    dp[i] = min(dp[i], i / 3);
                }
                if (i % 5 == 0) {
                    dp[i] = min(dp[i], i / 5);
                }
                dp[i] = min(dp[i], dp[i - 3] + 1);
                dp[i] = min(dp[i], dp[i - 5] + 1);
            }
        } else {
            dp[n] = -1;
            if (n == 3) {
                dp[n] = 1;
            }
        }

        if (dp[n] == n) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}