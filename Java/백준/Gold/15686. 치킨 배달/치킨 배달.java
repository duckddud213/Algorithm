import java.io.*;
import java.util.*;

public class Main {
    static int N, M, dist;
    static int city[][];
    static List<Pos> home;
    static List<Pos> chicken;

    public static void backTracking(int index, int depth, List<Pos> selected) {
        if (depth == M) {
            int sum = 0;

            for (Pos house : home) {
                int d = Integer.MAX_VALUE;
                for (Pos store : selected) {
                    d = Integer.min(d, Math.abs(store.x - house.x) + Math.abs(store.y - house.y));
                }
                sum += d;
            }

            dist = Integer.min(dist, sum);
            return;
        }

        for (int i = index; i < chicken.size(); i++) {
            selected.add(chicken.get(i));
            backTracking(i + 1, depth + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = Integer.MAX_VALUE;

        city = new int[N + 1][N + 1];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) {
                    chicken.add(new Pos(i, j));
                } else if (city[i][j] == 1) {
                    home.add(new Pos(i, j));
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        backTracking(0, 0, new ArrayList<Pos>());
        System.out.println(dist);
    }

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}