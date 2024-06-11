import java.io.*;
import java.util.*;

public class boj16236 {
    static int N, M, size, eat_cnt, time;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int water[][];
    static boolean isChecked[][];
    static PriorityQueue<Pos> pq;

    public static void bfs() {
        while (!pq.isEmpty()) {
            Pos cur = pq.poll();

            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;

            //해당 위치에 물고기를 먹을 수 있는 경우
            if (water[x][y] < size && water[x][y] != 0) {
                water[x][y] = 0;
                time += dist;
                eat_cnt++;
                dist = 0;
                isChecked = new boolean[N][N];
                pq.clear();
            }

            //성장이 가능한 경우
            if (eat_cnt == size) {
                size++;
                eat_cnt = 0;
            }

            for (int idx = 0; idx < 4; idx++) {
                if (isCanMovable(x + dx[idx], y + dy[idx]) && !isChecked[x+dx[idx]][y+dy[idx]]) {
                    pq.add(new Pos(x + dx[idx], y + dy[idx], dist + 1));
                    isChecked[x + dx[idx]][y + dy[idx]] = true;
                }
            }
        }
    }

    public static boolean isCanMovable(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N && water[x][y] <= size) {
            return true;
        }

        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        size = 2;
        eat_cnt = 0;
        time = 0;

        water = new int[N][N];
        isChecked = new boolean[N][N];
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                water[i][j] = Integer.parseInt(st.nextToken());
                if (water[i][j] == 9) {
                    water[i][j] = 0;
                    pq.add(new Pos(i, j, 0));
                    isChecked[i][j] = true;
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.println(time);
    }

    static class Pos implements Comparable<Pos> {
        int x, y, dist;

        public Pos() {
        }

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Pos o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }
}
