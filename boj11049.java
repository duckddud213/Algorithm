import java.io.*;
import java.util.*;

public class boj11049 {
    static int N, size;
    static int matrix[][], dp[][];

    public static void dynamic() {
        for (int i = 0; i < size - 1; i++) {
            dp[i][i + 1] = matrix[i][0] * matrix[i][1] * matrix[i + 1][1];
        }

        for (int i = 2; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                int tmp = i + j;

                dp[j][tmp] = Integer.MAX_VALUE;

                for (int k = j; k < tmp; k++) {
                    dp[j][tmp] = Math.min(dp[j][tmp],
                            dp[j][k] + dp[k + 1][tmp] + (matrix[j][0] * matrix[k][1] * matrix[tmp][1]));
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        size = matrix.length;

        dp = new int[size][size];
    }

    public static void main(String args[]) throws IOException {
        pre();
        dynamic();
        System.out.println(dp[0][size - 1]);
    }
}