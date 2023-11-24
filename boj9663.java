import java.io.*;
import java.util.*;

public class boj9663 {
    static int N, cnt;
    static int queens[];

    public static void backTracking(int depth) {
        int i, j, k;

        if (depth == N) {
            cnt++;
            return;
        }

        for (i = 0; i < N; i++) {
            for (j = 0; j < depth; j++) {
                if (queens[j] == i) {
                    break;
                }
            }

            if (j == depth) { // 중복값이 없는 경우
                queens[depth] = i;
            } else {
                continue;
            }

            for (k = 0; k < depth; k++) {
                if (Math.abs(queens[k] - queens[depth]) == Math.abs(depth - k)) { // 대각선에 위치한 다른 퀸이 있을시
                    break;
                }
            }

            if (k != depth) {
                continue;
            }

            backTracking(depth + 1);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;

        queens = new int[N];
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0);
        System.out.println(cnt);
    }
}
