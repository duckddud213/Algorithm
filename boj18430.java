import java.io.*;
import java.util.*;

public class boj18430 {
    static int N, M, sum, max;
    static int wood[][];
    static boolean isUsed[][];
    static int di[] = { 1, -1, -1, 1 };
    static int dj[] = { -1, -1, 1, 1 };

    public static int cal(int a, int b, int c) {
        return a * 2 + b + c;
    }

    public static void makeWeapon(int a, int b) {
        int i, j, idx, ni, nj;
        boolean check;
        max = Math.max(max, sum);

        if (!valid(a, b)) {
            return;
        }

        if (isUsed[a][b]) {
            j = b + 1;
            i = a;
            if (j == M) {
                i++;
                j = 0;
            }
            makeWeapon(i, j);
        } else {
            check = false;
            for (idx = 0; idx < 4; idx++) {
                ni = a + di[idx];
                nj = b + dj[idx];
                j = b + 1;
                i = a;
                if (j == M) {
                    i++;
                    j = 0;
                }
                if (valid(ni, nj) && !isUsed[a][b] && !isUsed[ni][b] && !isUsed[a][nj]) {
                    isUsed[ni][b] = true;
                    isUsed[a][nj] = true;
                    isUsed[a][b] = true;
                    sum += cal(wood[a][b], wood[ni][b], wood[a][nj]);
                    makeWeapon(i, j);
                    sum -= cal(wood[a][b], wood[ni][b], wood[a][nj]);
                    isUsed[a][b] = false;
                    isUsed[ni][b] = false;
                    isUsed[a][nj] = false;
                } else if (!check) {
                    check = true;
                    makeWeapon(i, j);
                }
            }
        }
    }

    public static boolean valid(int a, int b) {
        if (a >= 0 && a < N && b >= 0 && b < M) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;
        sum = 0;

        wood = new int[N][M];
        isUsed = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                wood[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        makeWeapon(0, 0); // (0,0) 좌표에서부터 시작
        System.out.println(max);
    }
}