import java.io.*;
import java.util.*;

public class Main {
    static int N, M, empty, day;
    static int box[][];
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static boolean isVisited[][];
    static HashSet<Pos> ripen;
    static PriorityQueue<Pos> pq;

    public static void bfs() {
        while (!pq.isEmpty()) {
            Pos cur = pq.poll();

            if (isVisited[cur.x][cur.y]) {
                continue;
            }

            isVisited[cur.x][cur.y] = true;
            ripen.add(new Pos(cur.x, cur.y, 0));
            day = Integer.max(day, cur.days);

            for (int idx = 0; idx < 4; idx++) {
                int dx = cur.x + dir[idx][0];
                int dy = cur.y + dir[idx][1];

                if (isValid(dx, dy) && !isVisited[dx][dy]) {
                    pq.add(new Pos(dx, dy, cur.days + 1));
                }
            }
        }

        if (ripen.size() + empty != N * M) {
            day = -1;
        }
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M && box[x][y] == 0;
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        empty = 0;
        day = 0;

        box = new int[N][M];
        isVisited = new boolean[N][M];
        ripen = new HashSet<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    pq.add(new Pos(i, j, 0));
                } else if (box[i][j] == -1) {
                    empty++;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        bfs();
        System.out.println(day);
    }

    static class Pos implements Comparable<Pos> {
        int x, y, days;

        public Pos(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.days == o.days) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.days - o.days;
        }
    }
}
