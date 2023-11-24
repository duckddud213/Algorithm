import java.io.*;
import java.util.*;

public class boj1987 {
    static int R, C, max;
    static char board[][];
    static boolean isChecked[][];
    static int str[];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void backTracking(int depth, int i, int j) {
        int idx;
        max = Math.max(max, depth);
        for (idx = 0; idx < 4; idx++) {
            if (isValid(i + dx[idx], j + dy[idx])) {
                if (str[board[i + dx[idx]][j + dy[idx]] - 'A'] == 0) {
                    str[board[i + dx[idx]][j + dy[idx]] - 'A'] = 1;
                    backTracking(depth + 1, i + dx[idx], j + dy[idx]);
                    str[board[i + dx[idx]][j + dy[idx]] - 'A'] = 0;
                }
            }
        }
    }

    public static boolean isValid(int i, int j) {
        if (i < 0) {
            return false;
        }
        if (i >= R) {
            return false;
        }
        if (j < 0) {
            return false;
        }
        if (j >= C) {
            return false;
        }
        return true;
    }

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = 0;

        board = new char[R][C];
        isChecked = new boolean[R][C];
        str = new int[26];

        for (i = 0; i < R; i++) {
            String input[] = br.readLine().split("");
            for (j = 0; j < C; j++) {
                board[i][j] = input[j].charAt(0);
            }
        }
        str[board[0][0] - 'A'] = 1;
        isChecked[0][0] = true;
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(1, 0, 0);
        System.out.println(max);
    }
}
