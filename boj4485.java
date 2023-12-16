import java.io.*;
import java.util.*;

public class boj4485 {
    static int N, T;
    static int cave[][];
    static int distance[][];
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static PriorityQueue<Road> pq;
    static StringBuilder sb;

    public static void Dijkstra() {
        pq.add(new Road(0, 0, cave[0][0]));
        distance[0][0] = cave[0][0];

        while (!pq.isEmpty()) {
            Road cur = pq.poll();

            for (int idx = 0; idx < 4; idx++) {
                int qi = cur.nextI + dx[idx];
                int qj = cur.nextJ + dy[idx];

                if (isValid(qi, qj)) {
                    if (distance[qi][qj] > distance[cur.nextI][cur.nextJ] + cave[qi][qj]) {
                        distance[qi][qj] = distance[cur.nextI][cur.nextJ] + cave[qi][qj];
                        pq.add(new Road(qi, qj, cave[qi][qj]));
                    }
                }
            }
        }

    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        T = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                return;
            }

            cave = new int[N][N];
            distance = new int[N][N];
            pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = 125*125*10;
                }
            }

            Dijkstra();
            sb.append("Problem " + T + ": " + distance[N - 1][N - 1]).append('\n');
            T++;
        }
    }

    public static boolean isValid(int i, int j) {
        if (i >= 0 && i < N && j >= 0 && j < N) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }

    static class Road implements Comparable<Road> {
        int nextI, nextJ, weight;

        public Road() {
        }

        public Road(int nextI, int nextJ, int weight) {
            this.nextI = nextI;
            this.nextJ = nextJ;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight - o.weight;
        }
    }

    public class Dot {
        int i, j;
    }
}