import java.io.*;
import java.util.*;

public class swea1949 {
    static int x, T, N, K, highest, longest;
    static int map[][];
    static Deque<dot> top;
    static boolean isChecked[][];
    static boolean isCarved;
    static int dx[] = { 1, 0, -1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static StringBuilder sb;

    public static void countRoad(int i, int j, int depth) {
        int idx, tmp;

        for (idx = 0; idx < 4; idx++) {
            if (isValid(i + dx[idx], j + dy[idx]) && !isChecked[i + dx[idx]][j + dy[idx]]) {
                if (map[i][j] > map[i + dx[idx]][j + dy[idx]]) {
                    isChecked[i + dx[idx]][j + dy[idx]] = true;
                    countRoad(i + dx[idx], j + dy[idx], depth + 1);
                    isChecked[i + dx[idx]][j + dy[idx]] = false;
                } else if (map[i + dx[idx]][j + dy[idx]] - map[i][j] < K && !isCarved) {
                    tmp = map[i + dx[idx]][j + dy[idx]];
                    map[i + dx[idx]][j + dy[idx]] = map[i][j] - 1;
                    isCarved = true;
                    isChecked[i + dx[idx]][j + dy[idx]] = true;
                    countRoad(i + dx[idx], j + dy[idx], depth + 1);
                    isChecked[i + dx[idx]][j + dy[idx]] = false;
                    isCarved = false;
                    map[i + dx[idx]][j + dy[idx]] = tmp;
                }
            }
        }

        longest = Math.max(longest, depth);
    }

    public static boolean isValid(int i, int j) {
        if (i < 0) {
            return false;
        }
        if (i >= N) {
            return false;
        }
        if (j < 0) {
            return false;
        }
        if (j >= N) {
            return false;
        }
        return true;
    }

    public static void pre() throws IOException {
        int i, j;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dot topLoc = new dot();

        T = Integer.parseInt(br.readLine());

        for (x = 1; x <= T; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            top = new ArrayDeque<>();
            highest = 0;
            isCarved = false;
            longest = 0;

            for (i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (highest < map[i][j]) {
                        top.clear();
                        highest = map[i][j];
                        top.add(new dot(i, j));
                    } else if (highest == map[i][j]) {
                        top.add(new dot(i, j));
                    }
                }
            }

            while (!top.isEmpty()) {
                isChecked = new boolean[N][N];
                isCarved = false;
                topLoc = top.poll();
                isChecked[topLoc.i][topLoc.j] = true;
                countRoad(topLoc.i, topLoc.j, 1);
            }
            sb.append("#").append(x).append(" ").append(longest).append('\n');
        }

    }

    public static void main(String args[]) throws IOException {
        sb = new StringBuilder();
        pre();
        System.out.print(sb);
    }

    static class dot {
        int i, j;

        public dot() {
        }

        public dot(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}