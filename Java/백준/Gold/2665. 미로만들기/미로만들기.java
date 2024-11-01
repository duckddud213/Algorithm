import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int map[][], result[][];
    static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    static PriorityQueue<Node> pq;

    public static void bfs() {
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(cur.cnt >= result[cur.x][cur.y]){
                continue;
            }

            result[cur.x][cur.y] = cur.cnt;

            if (cur.x == N - 1 && cur.y == N - 1) {
                return;
            }

            for (int idx = 0; idx < 4; idx++) {
                int dx = cur.x + dir[idx][0];
                int dy = cur.y + dir[idx][1];

                if (isValid(dx, dy)) {
                    pq.add(new Node(dx, dy, cur.cnt + rValue(map[dx][dy])));
                }
            }
        }
    }

    public static boolean isValid(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    public static int rValue(int num) {
        if (num == 1) {
            return 0;
        }
        else
            return 1;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        result = new int[N][N];

        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                Arrays.fill(result[i],Integer.MAX_VALUE);
                map[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        pq.add(new Node(0, 0, 0));
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.println(result[N-1][N-1]);
    }

    static class Node implements Comparable<Node> {
        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return this.cnt - o.cnt;
        }
    }
}