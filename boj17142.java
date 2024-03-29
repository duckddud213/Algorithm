import java.io.*;
import java.util.*;

public class boj17142 {
    static int N, M, min;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static boolean isSelectedVirus[];
    static int lab[][];
    static boolean isInfected[][];
    static List<Pos> virus;
    static List<Pos> startPoint;
    static PriorityQueue<Pos> que;

    public static void bfs() {
        int cost = 0;

        for (int i = 0; i < startPoint.size(); i++) {
            que.add(startPoint.get(i));
        }

        while (!que.isEmpty()) {
            Pos cur = que.poll();

            if (isInfected[cur.x][cur.y]) {
                continue;
            }

            cost = Integer.max(cost, cur.time);
            // System.out.println("current cost is : " + cost);
            isInfected[cur.x][cur.y] = true;

            for (int idx = 0; idx < 4; idx++) {
                int ix = cur.x + dx[idx];
                int iy = cur.y + dy[idx];

                if (isValid(ix, iy)) {
                    if (lab[ix][iy] == 0) {
                        que.add(new Pos(ix, iy, cur.time + 1));
                    }
                    if (lab[ix][iy] == 2) {
                        que.add(new Pos(ix, iy, cur.time));
                    }
                }
            }
        }

        // System.out.println("current min and cost : " + min + " " + cost);
        min = Integer.min(min, cost);
    }

    public static boolean isValid(int i, int j) {
        if (i >= 0 && i < N & j >= 0 && j < N && (lab[i][j] == 0 || lab[i][j] == 2)) {
            return true;
        }
        return false;
    }

    public static void backTracking(int depth) {
        if (depth == M) {
            que.clear();
            isInfected = new boolean[N][N];
            // System.out.println("virus");
            for (int i = 0; i < startPoint.size(); i++) {
                // System.out.print(startPoint.get(i).x+"/"+startPoint.get(i).y + " ");
            }
            // System.out.println();
            bfs();
            return;
        }

        for (int i = 0; i < virus.size(); i++) {
            if (!isSelectedVirus[i]) {
                isSelectedVirus[i] = !isSelectedVirus[i];
                startPoint.add(virus.get(i));

                backTracking(depth + 1);

                isSelectedVirus[i] = !isSelectedVirus[i];
                startPoint.remove(startPoint.size() - 1);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        lab = new int[N][N];
        isInfected = new boolean[N][N];
        virus = new ArrayList<>();
        startPoint = new ArrayList<>();
        que = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virus.add(new Pos(i, j, 0));
                }
            }
        }

        
        isSelectedVirus = new boolean[virus.size()];
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static class Pos implements Comparable<Pos> {
        int x, y, time;

        public Pos() {
        }

        public Pos(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) {
            return this.time - o.time;
        }
    }
}
