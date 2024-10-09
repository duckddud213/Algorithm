import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, result;
    static int dir[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };
    static Deque<Fireball> list;
    static List<Fireball> map[][];

    public static void moveFireball() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        while (!list.isEmpty()) {
            Fireball ball = list.poll();
            int dx = relocator(ball.r + (dir[ball.d][0] * ball.s));
            int dy = relocator(ball.c + (dir[ball.d][1] * ball.s));

            map[dx][dy].add(new Fireball(dx, dy, ball.m, ball.s, ball.d));
        }
    }

    public static int relocator(int num) {
        if (num < 1) {
            return N - (Math.abs(num) % N);
        }
        else {
            return (num - 1) % N + 1;
        }
    }

    public static void combineAndDivide(int r, int c) {
        int mass, velo, size;
        boolean isOdd, isEven;

        mass = 0;
        velo = 0;
        size = map[r][c].size();
        isOdd = false;
        isEven = false;

        for (Fireball next : map[r][c]) {
            mass += next.m;
            velo += next.s;
            if (next.d % 2 == 0) {
                isEven = true;
            }
            else {
                isOdd = true;
            }
        }

        mass /= 5;
        velo /= size;

        if (mass == 0) {
            return;
        }

        if (isEven && isOdd) {
            for (int idx = 1; idx < 8; idx += 2) {
                list.add(new Fireball(r, c, mass, velo, idx));
            }
        }
        else {
            for (int idx = 0; idx < 8; idx += 2) {
                list.add(new Fireball(r, c, mass, velo, idx));
            }
        }
    }

    public static void magic() {
        for (int tc = 0; tc < K; tc++) {
            moveFireball();
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j].size() >= 1) {
                        if (map[i][j].size() >= 2) {
                            combineAndDivide(i, j);
                        }
                        else {
                            list.add(new Fireball(i, j, map[i][j].get(0).m, map[i][j].get(0).s, map[i][j].get(0).d));
                        }
                    }
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;

        list = new ArrayDeque<>();
        map = new List[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Fireball(r, c, m, s, d));
        }
    }

    public static void makeResult() {
        for (Fireball ball : list) {
            result += ball.m;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        magic();
        makeResult();
        System.out.println(result);
    }

    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}