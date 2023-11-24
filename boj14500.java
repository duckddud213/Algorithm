import java.io.*;
import java.util.*;

public class boj14500 {
	static int N, M, maxSum;
	static int board[][];

	public static void tetrio() {
		int i, j;

		for (i = 0; i < N; i++) {
			for (j = 0; j < M; j++) {
				if (isValid(i, 3, j, 0)) {// 1번
					maxSum = Math.max(maxSum, board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 3][j]);
				}
				if (isValid(i, 0, j, 3)) {// 2번
					maxSum = Math.max(maxSum, board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i][j + 3]);
				}

				if (isValid(i, 1, j, 1)) {// 3번
					maxSum = Math.max(maxSum, board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i][j + 1]);
				}

				if (isValid(i, 2, j, 1)) {// 4번
					maxSum = Math.max(maxSum, board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 2][j + 1]);
				}
				if (isValid(i, 1, j, 2)) {// 5번
					maxSum = Math.max(maxSum, board[i][j] + board[i + 1][j] + board[i][j + 1] + board[i][j + 2]);
				}
				if (isValid(i, 2, j, 1)) {// 6번
					maxSum = Math.max(maxSum,
							board[i][j] + board[i + 1][j + 1] + board[i + 2][j + 1] + board[i][j + 1]);
				}
				if (isValid(i, -1, j, 2)) {// 7번
					maxSum = Math.max(maxSum, board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i - 1][j + 2]);
				}
				if (isValid(i, 2, j, 1)) {// 8번
					maxSum = Math.max(maxSum, board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i][j + 1]);
				}
				if (isValid(i, -2, j, 1)) {// 9번
					maxSum = Math.max(maxSum,
							board[i][j] + board[i][j + 1] + board[i - 1][j + 1] + board[i - 2][j + 1]);
				}
				if (isValid(i, 1, j, 2)) {// 10번
					maxSum = Math.max(maxSum,
							board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2]);
				}
				if (isValid(i, 1, j, 2)) {// 11번
					maxSum = Math.max(maxSum, board[i][j] + board[i][j + 1] + board[i][j + 2] + board[i + 1][j + 2]);
				}

				if (isValid(i, 2, j, 1)) {// 12번
					maxSum = Math.max(maxSum,
							board[i][j] + board[i + 1][j] + board[i + 1][j + 1] + board[i + 2][j + 1]);
				}
				if (isValid(i, 2, j, -1)) {// 13번
					maxSum = Math.max(maxSum,
							board[i][j] + board[i + 1][j] + board[i + 1][j - 1] + board[i + 2][j - 1]);
				}
				if (isValid(i, -1, j, 2)) {// 14번
					maxSum = Math.max(maxSum,
							board[i][j] + board[i][j + 1] + board[i - 1][j + 1] + board[i - 1][j + 2]);
				}
				if (isValid(i, 1, j, 2)) {// 15번
					maxSum = Math.max(maxSum,
							board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i + 1][j + 2]);
				}

				if (isValid(i, 1, j, 2)) {// 16 번
					maxSum = Math.max(maxSum, board[i][j] + board[i][j + 1] + board[i + 1][j + 1] + board[i][j + 2]);
				}
				if (isValid(i, 2, j, -1)) {// 17 번
					maxSum = Math.max(maxSum, board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 1][j - 1]);
				}
				if (isValid(i, -1, j, 2)) {// 18 번
					maxSum = Math.max(maxSum, board[i][j] + board[i][j + 1] + board[i - 1][j + 1] + board[i][j + 2]);
				}
				if (isValid(i, 2, j, 1)) {// 19 번
					maxSum = Math.max(maxSum, board[i][j] + board[i + 1][j] + board[i + 2][j] + board[i + 1][j + 1]);
				}

			}
		}
	}

	public static boolean isValid(int i, int plusI, int j, int plusJ) {
		if (i + plusI >= N) {
			return false;
		}
		if (i + plusI < 0) {
			return false;
		}
		if (j + plusJ >= M) {
			return false;
		}
		if (j + plusJ < 0) {
			return false;
		}

		return true;
	}

	public static void pre() throws IOException {
		int i, j;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maxSum = 0;

		board = new int[N][M];

		for (i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		pre();
		tetrio();
		System.out.println(maxSum);
	}

}
