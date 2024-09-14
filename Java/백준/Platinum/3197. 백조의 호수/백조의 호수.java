import java.io.*;
import java.util.*;

public class Main {
    static int R, C, time;
    static int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    static char lake[][];
    static boolean check[][];
    static List<Pos> swan;
    static Deque<Pos> water, src, que;

    public static void melting() {
        int size = water.size();
        for (int i = 0; i < size; i++) {
            Pos cur = water.poll();

            for (int idx = 0; idx < 4; idx++) {
                int dx = cur.r + dir[idx][0];
                int dy = cur.c + dir[idx][1];

                if (!isValid(dx, dy)) {
                    continue;
                }

                if (lake[dx][dy] == 'X') {
                    lake[dx][dy] = '.';
                    water.add(new Pos(dx, dy));
                }
            }
        }
    }

    public static boolean move() {
        que = new ArrayDeque<>();

        while (!src.isEmpty()) {
            Pos cur = src.poll();
            if (cur.r == swan.get(1).r && cur.c == swan.get(1).c) {
                return true;
            }

            for (int idx = 0; idx < 4; idx++) {
                int dx = cur.r + dir[idx][0];
                int dy = cur.c + dir[idx][1];

                if (!isValid(dx, dy) || check[dx][dy]) {
                    continue;
                }

                check[dx][dy] = true;

                if (lake[dx][dy] == '.') {
                    src.add(new Pos(dx, dy));
                }
                else if (lake[dx][dy] == 'X') {
                    que.add(new Pos(dx, dy));
                }
            }
        }
        src = que;
        return false;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        time = 0;

        lake = new char[R][C];
        check = new boolean[R][C];
        swan = new ArrayList<>();
        water = new ArrayDeque<>();
        src = new ArrayDeque<>();
        que = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = input.charAt(j);
                if (lake[i][j] == 'L') {
                    swan.add(new Pos(i, j));
                    lake[i][j] = '.';
                }

                if (lake[i][j] == '.') {
                    water.add(new Pos(i, j));
                }
            }
        }

        src.add(swan.get(0));
        check[swan.get(0).r][swan.get(0).c] = true;
    }

    public static void main(String args[]) throws IOException {
        pre();
        while (true) {
            if(move()){
                break;
            }
            melting();
            time++;
        }
        System.out.println(time);
    }

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}