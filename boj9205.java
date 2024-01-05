import java.io.*;
import java.util.*;

public class boj9205 {
    static int x, T, N;
    static Deque<Pos> store;
    static Pos home, festival;
    static List<Pos> notVisited;
    static StringBuilder sb;

    public static void bfs() {
        store.add(home);

        while (!store.isEmpty()) {
            Pos cur = store.poll();

            if (cur.x == festival.x && cur.y == festival.y) {
                sb.append("happy").append('\n');
                return;
            }

            for (int i = 0; i < notVisited.size(); i++) {
                Pos next = notVisited.get(i);
                if (ManhattanDist(next.x, next.y, cur.x, cur.y) <= 1000) {
                    store.add(next);
                    notVisited.remove(i);
                    i--;
                }
            }
        }
        
        sb.append("sad").append('\n');
    }

    public static int ManhattanDist(int x1,int y1,int x2,int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        store = new ArrayDeque<>();
        sb = new StringBuilder();
        notVisited = new ArrayList<>();

        for (int x = 1; x <= T; x++) {
            N = Integer.parseInt(br.readLine());
            store.clear();
            notVisited.clear();

            st = new StringTokenizer(br.readLine());
            home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                notVisited.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());
            festival = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            notVisited.add(festival);

            bfs();
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }

    static class Pos {
        int x, y;

        public Pos() {
        }

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
