import java.io.*;
import java.util.*;

public class boj1261 {
    static int N, M, min;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static List<Integer>[] maze;
    static boolean isVisited[][];
    static PriorityQueue<Pos> pq;

    public static void Dijkstra() {
        pq.add(new Pos(1, 1, 0));

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();

            if (cur.x == N && cur.y == M) {
                min = cur.weight;
                return;
            }

            if(isVisited[cur.x][cur.y]){
                continue;
            }
            isVisited[cur.x][cur.y]=true;

            for (int idx = 0; idx < 4; idx++) {
                int qx = cur.x + dx[idx];
                int qy = cur.y + dy[idx];
                if (isValid(qx, qy) && !isVisited[qx][qy]) {
                    pq.add(new Pos(qx, qy, cur.weight + maze[qx].get(qy - 1)));
                }
            }
        }
    }

    public static boolean isValid(int x, int y) {
        if (x >= 1 && x <= N && y >= 1 && y <= M) {
            return true;
        }

        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        min = 20000;

        maze = new List[N + 1];
        isVisited = new boolean[N + 1][M + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            String input[] = br.readLine().split("");
            maze[i] = new ArrayList<>();
            for (int j = 1; j <= M; j++) {
                maze[i].add(Integer.parseInt(input[j - 1]));
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        Dijkstra();
        System.out.println(min);
    }

    static class Pos implements Comparable<Pos> {
        int x, y, weight;

        public Pos() {
        }

        public Pos(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight=weight;
        }

        @Override
        public int compareTo(Pos o) {
            return this.weight - o.weight;
        }
    }
}