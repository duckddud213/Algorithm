import java.io.*;
import java.util.*;

public class Main {
    static int N, result, num;
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int map[][], group[][];
    static Deque<Pos> que;
    static Deque<Bridge> road;

    public static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) {
                    continue;
                }

                road = new ArrayDeque<>();
                road.add(new Bridge(i, j, 0));
                boolean isVisited[][] = new boolean[N][N];
                int gnum = group[i][j];

                while (!road.isEmpty()) {
                    Bridge cur = road.poll();

                    if (isVisited[cur.x][cur.y]) {
                        continue;
                    }

                    isVisited[cur.x][cur.y] = true;
                    if (group[cur.x][cur.y] != 0 && group[cur.x][cur.y] != gnum) {
                        // 다른 섬일때
                        result = Math.min(result, cur.len - 1);
                        break;
                    }

                    for (int idx = 0; idx < 4; idx++) {
                        int dx = cur.x + dir[idx][0];
                        int dy = cur.y + dir[idx][1];

                        if (isValid(dx, dy) && group[dx][dy] != gnum && !isVisited[dx][dy]) {
                            road.add(new Bridge(dx, dy, cur.len + 1));
                        }
                    }
                }
            }
        }
    }

    public static void grouping() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    que = new ArrayDeque<>();
                    que.add(new Pos(i, j));

                    while (!que.isEmpty()) {
                        Pos cur = que.poll();

                        if (group[cur.x][cur.y] != 0) {
                            continue;
                        }

                        group[cur.x][cur.y] = num;

                        for (int idx = 0; idx < 4; idx++) {
                            int dr = cur.x + dir[idx][0];
                            int dc = cur.y + dir[idx][1];

                            if (isValid(dr, dc) && (group[dr][dc] == 0) && map[dr][dc] == 1) {
                                que.add(new Pos(dr, dc));
                            }
                        }
                    }
                    num++;
                }
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        num = 1;

        map = new int[N][N];
        group = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        grouping();
        bfs();
        System.out.println(result);
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Bridge {
        int x, y, len;

        public Bridge(int x, int y, int len) {
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
}