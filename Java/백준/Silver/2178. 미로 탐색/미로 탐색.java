import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int maze[][];
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean isVisited[][];

    public static void escapeMaze() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();

        pq.add(new Pos(0, 0, 1));

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();

            if (isVisited[cur.x][cur.y]) {
                continue;
            }

            if (cur.x == N - 1 && cur.y == M - 1) {
                System.out.println(cur.cnt);
            }

            isVisited[cur.x][cur.y] = true;

            for (int idx = 0; idx < 4; idx++) {
                int cx = cur.x + dir[idx][0];
                int cy = cur.y + dir[idx][1];

                if (isValid(cx, cy)) {
                    pq.add(new Pos(cx, cy, cur.cnt + 1));
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && (maze[x][y] == 1);
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        escapeMaze();
    }

    static class Pos implements Comparable<Pos> {
        int x, y, cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cnt - o.cnt;
        }
    }
}
