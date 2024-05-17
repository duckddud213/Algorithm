import java.io.*;
import java.util.*;

public class boj5014 {
    static int F, S, G, U, D;
    static HashSet<Integer> isVisited;
    static Deque<Floor> que;

    public static void bfs() {
        que.add(new Floor(S, 0));

        while (!que.isEmpty()) {
            Floor cur = que.poll();

            if (isVisited.contains(cur.num)) {
                continue;
            }
            isVisited.add(cur.num);

            if (cur.num == G) {
                System.out.println(cur.cnt);
                return;
            }

            if (cur.num + U <= F) {
                que.add(new Floor(cur.num + U, cur.cnt + 1));
            }
            if (cur.num - D >= 1) {
                que.add(new Floor(cur.num - D, cur.cnt + 1));
            }
        }

        System.out.println("use the stairs");
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        que = new ArrayDeque<>();
        isVisited = new HashSet<>();
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
    }

    static class Floor {
        int num, cnt;

        public Floor() {
        }

        public Floor(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}