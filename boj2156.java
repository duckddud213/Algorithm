import java.io.*;
import java.util.*;

public class boj2156 {
    static int N, max, max_sum;
    static int wine[];
    static int sum[];

    public static void doDP() {
        int i;
        if (N <= 2) {
            sum[N] = 0;
            for (i = 1; i <= N; i++) {
                sum[N] += wine[i];
            }
            max = sum[N];
            return;
        }

        sum[1] = wine[1];
        sum[2] = wine[1] + wine[2];
        max = sum[2];

        sum[3] = wine[3] + Math.max(wine[1], wine[2]);
        max = Math.max(max, sum[3]);
        max_sum = 0;

        for (i = 4; i <= N; i++) {
            sum[i] = Integer.MIN_VALUE;
            if (i == 4) {
                sum[i] = wine[i] + Math.max(wine[i - 1], wine[i - 2]) + wine[i - 3];
                max_sum = sum[i - 3];
            } else {
                max_sum = Math.max(max_sum, sum[i - 3]);
                sum[i] = wine[i] + Math.max(wine[i - 1] + max_sum, sum[i - 2]);
            }

            max = Math.max(max, sum[i]);
        }
    }

    public static void main(String args[]) throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        wine = new int[N + 1];
        sum = new int[N + 1];
        for (i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        doDP();

        System.out.println(max);
    }
}
