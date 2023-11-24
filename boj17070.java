import java.io.*;
import java.util.*;

public class boj17070 {
    static int N, cnt;
    static int board[][];

    public static void backTracking(int i, int j, int dir) { // dir 1 : ���� dir 2 : �밢�� dir 3 : ����
        if (i == N - 1 && j == N - 1) {
            cnt++;
            return;
        }

        if (dir == 1) { // ���� �������� ���� ������ ���
            if (isValid(i, j + 1)) {
                if (isValid(i + 1, j) && isValid(i + 1, j + 1)) {
                    backTracking(i + 1, j + 1, 2); // �밢�� ���� �̵�
                }
                backTracking(i, j + 1, 1); // ���� ���� �̵�
            }
        } else if (dir == 2) { // ���� �������� �밢�� ������ ���
            if (isValid(i + 1, j) && isValid(i, j + 1) && isValid(i + 1, j + 1)) {
                backTracking(i + 1, j + 1, 2); // �밢�� ���� �̵�
            }
            if (isValid(i + 1, j)) {
                    backTracking(i + 1, j, 3); // ���� ���� �̵�
                }
            if (isValid(i, j + 1)) {
                    backTracking(i, j + 1, 1); // ���� ���� �̵�
                }
            }
         else if (dir == 3) { // ���� �������� ���� ������ ���
            if (isValid(i + 1, j)) {
                if (isValid(i, j + 1) && isValid(i + 1, j + 1)) {
                    backTracking(i + 1, j + 1, 2); // �밢�� ���� �̵�
                }
                backTracking(i + 1, j, 3); // ���� ���� �̵�
            }
        }
    }

    public static boolean isValid(int i, int j) {
        if (i >= N) {
            return false;
        }
        if (j >= N) {
            return false;
        }
        if (board[i][j] == 1) {
            return false;
        }
        return true;
    }

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = 0;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0, 1, 1);
        System.out.println(cnt);
    }
}