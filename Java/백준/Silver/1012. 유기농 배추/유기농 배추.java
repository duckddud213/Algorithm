import java.io.*;
import java.util.*;

public class Main {
    static int T, M, N, K, cnt;
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static int map[][];
    static boolean isVisited[][];
    static Deque<Pos> que;
    static StringBuilder sb;

    public static void BFS() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    cnt++;

                    que.add(new Pos(i, j));

                    while (!que.isEmpty()) {
                        Pos cur = que.poll();

                        if (isVisited[cur.x][cur.y]) {
                            continue;
                        }
                        isVisited[cur.x][cur.y] = true;

                        for (int idx = 0; idx < 4; idx++) {
                            int dx = cur.x + dir[idx][0];
                            int dy = cur.y + dir[idx][1];

                            if (isValid(dx, dy) && map[dx][dy] == 1 && !isVisited[dx][dy]) {
                                que.add(new Pos(dx, dy));
                            }
                        }
                    }

                    que.clear();
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        que = new ArrayDeque<>();
        sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            cnt = 0;

            map = new int[N][M];
            isVisited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            BFS();
            sb.append(cnt).append("\n");
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        System.out.println(sb);
    }

    static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
