import java.io.*;
import java.util.*;

public class boj1799 {

    static int N, result, ans;
    static boolean isUsed[][];
    static int chess[][];
    static int answer[], left[], right[];

    private static void backTracking(int R, int C, int cnt, boolean white) {
        if (ans < cnt)
            ans = cnt;
        if (C >= N - 1) {
            R = R + 1;
        }
        for (int i = R; i < N; i++) {
            for (int j = white ? (i % 2 == 0 ? 0 : 1) : (i % 2 == 0 ? 1 : 0); j < N; j += 2) {
                if (chess[i][j] == 0 || isUsed[i + j][0] || isUsed[i - j + N][1])
                    continue;
                isUsed[i + j][0] = true;
                isUsed[i - j + N][1] = true;
                backTracking(i, j, cnt + 1, white);
                isUsed[i + j][0] = false;
                isUsed[i - j + N][1] = false;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        chess = new int[N][N];
        isUsed = new boolean[2 * N + 1][N];
        answer = new int[2];
        result = 0;
        ans = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0, 0, 0, false);
        result += ans;
        ans = 0;
        backTracking(0, 0, 0, true);
        System.out.println(result + ans);
    }
}
