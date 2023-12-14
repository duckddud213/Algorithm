import java.io.*;
import java.util.*;

public class boj7569 {
    static int N, M, H, time,initSize;
    static int tomato[][][];
    static Deque<Pos> ripe;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int dz[] = { -1, 1};
    static HashSet<Dot> isVisited;

    public static void bfs() {
        while (!ripe.isEmpty()) {
            Pos next = ripe.poll();
            time = Math.max(time, next.time);

            for (int idx = 0; idx < 4; idx++) {
                int pi = next.width + dx[idx];
                int pj = next.height + dy[idx];
                int pk = next.depth;

                if (isValid(pi, pj, pk) && tomato[pi][pj][pk] == 0) {
                    Pos addNext = new Pos(pi, pj, pk);
                    addNext.time = next.time + 1;
                    ripe.add(addNext);
                    isVisited.add(new Dot(pi, pj, pk));
                    tomato[pi][pj][pk] = 1;
                }
            }
            
            for (int idx = 0; idx < 2; idx++) {
                int pi = next.width;
                int pj = next.height;
                int pk = next.depth + dz[idx];
                
                if (isValid(pi, pj, pk) && tomato[pi][pj][pk] == 0) {
                    Pos addNext = new Pos(pi, pj, pk);
                    addNext.time = next.time + 1;
                    ripe.add(addNext);
                    isVisited.add(new Dot(pi, pj, pk));
                    tomato[pi][pj][pk] = 1;
                }
            }
        }
        
        if (isVisited.size() != N * M * H) {
            time = -1;
        }
        else if (isVisited.size() == initSize) {
            time = 0;
        }
    }

    public static boolean isValid(int i, int j, int k) {
        if (i >= 0 && i < N && j >= 0 && j < M && k >= 0 && k < H && !isVisited.contains(new Dot(i,j,k))) {
            return true;
        }
        return false;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        time = 0;

        ripe = new ArrayDeque<>();
        isVisited = new HashSet<>();
        tomato = new int[N][M][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) {
                        ripe.add(new Pos(i, j, k));
                        isVisited.add(new Dot(i, j, k));
                    } 
                    else if (tomato[i][j][k] == -1) {
                        isVisited.add(new Dot(i, j, k));
                    }
                }
            }
        }
        initSize = isVisited.size();
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.println(time);
    }

    static class Pos {
        int width, height, depth, time;

        public Pos() {
        }

        public Pos(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
            time = 0;
        }
    }

    static class Dot {
        int width, height, depth;

        public Dot() {
        }

        public Dot(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }
    }
}
