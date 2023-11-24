import java.io.*;
import java.util.*;

public class boj14499 {
    static int N, M, x, y, K;
    static int map[][];
    static int dice[][];
    static List<Integer> move;
    static int dx[] = { 0, 0, -1, 1 };
    static int dy[] = { 1, -1, 0, 0 };

    public static void turnDice() {
        int tmp;
        int dir = move.get(0);
        if (dir == 1) {
            tmp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = tmp;
        } else if (dir == 2) {
            tmp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = tmp;
        } else if (dir == 3) {
            tmp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = tmp;
        } else if (dir == 4) {
            tmp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = tmp;
        }

        x += dx[dir - 1];
        y += dy[dir - 1];

        if (map[x][y] == 0) {
            map[x][y] = dice[3][1];
        } else {
            dice[3][1] = map[x][y];
            map[x][y] = 0;
        }
    }

    public static void rollDice() {
        for (int i = 0; i < K; i++) {
            if (valid(x + dx[move.get(0) - 1], y + dy[move.get(0) - 1])) {
                turnDice();
                System.out.println(dice[1][1]);
            }

            move.remove(0);
        }
    }

    public static boolean valid(int a, int b) {
        if (a < 0) {
            return false;
        }
        if (a >= N) {
            return false;
        }
        if (b < 0) {
            return false;
        }
        if (b >= M) {
            return false;
        }
        return true;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        move = new ArrayList<>();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            move.add(Integer.parseInt(st.nextToken()));
        }

        dice = new int[4][3];
        dice[0][1] = 0;
        dice[1][0] = 0;
        dice[1][1] = 0;
        dice[1][2] = 0;
        dice[2][1] = 0;
        dice[3][1] = 0;
    }

    public static void main(String args[]) throws IOException {
        pre();
        rollDice();
    }
}
