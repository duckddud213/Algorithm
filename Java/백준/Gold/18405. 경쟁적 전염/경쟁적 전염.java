import java.io.*;
import java.util.*;

public class Main {
    static int N, K, S, X, Y;
    static int map[][];
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static Deque<Pos> list[];

    public static void bfs() {
        for (int tc = 0; tc < S; tc++) {
            for (int i = 1; i <= K; i++) {
                int size = list[i].size();

                for (int t = 0; t < size; t++) {
                    Pos cur = list[i].poll();

                    for (int idx = 0; idx < 4; idx++) {
                        int dx = cur.x + dir[idx][0];
                        int dy = cur.y + dir[idx][1];

                        if(isValid(dx, dy)){
                            list[i].add(new Pos(dx,dy));
                            map[dx][dy] = i;
                        }
                    }
                }
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N && map[r][c] == 0;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        list = new Deque[K + 1];

        for(int i = 1; i <= K; i++){
            list[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0) {
                    list[map[i][j]].add(new Pos(i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.println(map[X - 1][Y - 1]);
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}