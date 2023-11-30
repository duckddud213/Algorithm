import java.io.*;
import java.util.*;

public class boj2887 {
    static int N;
    static long sum;
    static PriorityQueue<Star> pq;
    static Deque<Star>[] connect;
    static HashSet<Integer> stellar;
    static List<int[]> stars;

    public static void Prim() {

        pq.add(new Star(1, 0));

        while (!pq.isEmpty()) {
            Star que = pq.poll();

            if (stellar.contains(que.next)) {
                continue;
            }

            stellar.add(que.next);
            sum += (long)que.dist;

            while (!connect[que.next].isEmpty()) {
                Star connection = connect[que.next].poll();

                if (!stellar.contains(connection.next)) {
                    pq.add(connection);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sum = 0;
        pq = new PriorityQueue<>();
        connect = new Deque[N + 1];
        stellar = new HashSet<>();
        stars = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            stars.add(new int[] { (int) i, x, y, z });

            connect[i] = new ArrayDeque<>();
        }

        for (int idx = 1; idx <= 3; idx++) {
            int x = idx;
            Collections.sort(stars, (o1, o2) -> (int) (o1[x] - o2[x]));

            for (int i = 2; i <= N; i++) {
                int[] o1 = stars.get(i - 2);
                int[] o2 = stars.get(i-1);
                int distance = Math.abs(o1[idx] - o2[idx]);

                connect[o1[0]].add(new Star(o2[0], distance));
                connect[o2[0]].add(new Star(o1[0], distance));
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        Prim();
        System.out.println(sum);
    }

    static class Star implements Comparable<Star> {
        int next;
        int dist;

        public Star() {
        }

        public Star(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }

        @Override
        public int compareTo(Star o) {
            if (this.dist > o.dist) {
                return 1;
            } 
            else
                return -1;
        }
    }
}
