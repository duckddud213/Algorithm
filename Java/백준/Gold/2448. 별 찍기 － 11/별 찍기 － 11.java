import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] board;
    static StringBuilder sb;

    public static void star(int i, int j, int size) {
        if (size == 3) {
            board[i][j + 2] = board[i + 1][j + 1] = board[i + 1][j + 3] = true;
            for (int k = 0; k < 5; k++)
                board[i + 2][j + k] = true;
            return;
        }

        int resize = size / 2;
        star(i, j + resize, resize);
        star(i + resize, j, resize);
        star(i + resize, j + size, resize);
    }

    public static void makeResult() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++) {
                if (board[i][j])
                    sb.append('*');
                else
                    sb.append(' ');
            }
            sb.append('\n');
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N * 2];

        sb = new StringBuilder();
    }

    public static void main(String[] args) throws IOException {
        pre();
        star(0, 0, N);
        makeResult();
        System.out.print(sb);
    }
}