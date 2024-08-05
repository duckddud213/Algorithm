import java.io.*;
import java.util.*;

public class Main {
    static int N, M, shortest;
    static int map[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static boolean isVisited[][][];
    static Deque<Dot> que;

    public static void bfs() {
        int i, j, idx, check;

        isVisited = new boolean[N][M][2];
        que.add(new Dot(0, 0, 1,false));
        isVisited[0][0][0] = true;

        while (!que.isEmpty()) {
            Dot qDot = que.poll();
            check = (qDot.isDestroyed == false) ? 0 : 1; // 벽이 파괴하지 않았으면 0, 파괴했으면 1

            if (qDot.i == N - 1 && qDot.j == M - 1) {
                shortest = Math.min(shortest, qDot.len);
            }

            for (idx = 0; idx < 4; idx++) {
                i = qDot.i + dx[idx];
                j = qDot.j + dy[idx];

                if (isValid(i, j) &&!isVisited[i][j][check] &&map[i][j] == 0) { //현재 좌표에서 인접한 이동할 수 있는 곳이 있는 경우(파괴 여부 상관X)
                    isVisited[i][j][check] = true;
                    que.add(new Dot(i, j, qDot.len + 1, qDot.isDestroyed));
                } 
                if (isValid(i, j) && !isVisited[i][j][1] && map[i][j] == 1 && check == 0) { //현재 좌표에서 인접한 벽이 있고, 이전 경로 이동 과정에서 아직 벽을 부수지 않은 경우
                    isVisited[i][j][1] = true;
                    que.add(new Dot(i, j, qDot.len + 1, true));
                }
            }
            
        }

        shortest = (shortest == Integer.MAX_VALUE )? -1 : shortest;
    }

    public static boolean isValid(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < M) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input[];
        que = new ArrayDeque<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        shortest = Integer.MAX_VALUE;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.println(shortest);
    }

    static class Dot {
        int i, j, len;
        boolean isDestroyed;

        public Dot() {
        }

        public Dot(int i, int j, int len, boolean isDestroyed) {
            this.i = i;
            this.j = j;
            this.len = len;
            this.isDestroyed = isDestroyed;
        }
    }
}