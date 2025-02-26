import java.io.*;
import java.util.*;

public class Main {
	static int X, result;
	static int dp[];

	public static void greedy() {
		for (int i = 1; i <= X; i++) {
			dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
			dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
			dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
		}

		result = dp[X];
	}

	public static void pre() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		X = Integer.parseInt(br.readLine());

		dp = new int[X * 3 + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);

		dp[1] = 0;
	}

	public static void main(String[] args) throws IOException {
		pre();
		greedy();
		System.out.println(result);
	}
}