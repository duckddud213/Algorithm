import java.io.*;
import java.util.*;

public class boj5557 {
	static int N;
	static int[] operand;
	static long[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		operand = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			operand[i] = Integer.parseInt(st.nextToken());
		}

		dp = new long[21][100];

		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j < 100; j++) {
				dp[i][j] = -1;
			}
		}

        System.out.println(recursion(operand[0], 0));
	}

	public static long recursion(int sum, int idx) {
        if (sum < 0 || sum > 20) {
            return 0;
        }
        
		if (idx == N - 2) {
			return (sum == operand[N - 1]) ? 1 : 0;
		}

		if (dp[sum][idx] != -1) {
			return dp[sum][idx];
		}

		dp[sum][idx] = 0;
		
		return dp[sum][idx] += recursion(sum + operand[idx + 1], idx + 1) + recursion(sum - operand[idx + 1], idx + 1);
	}

}