import java.io.*;
import java.util.*;

public class boj17396 {
    static int N, M, total;
    static HashSet<Integer> isVisible;
    static long distance[];
    static List<Road> connection[];
    static PriorityQueue<Road> pq;
    static boolean isVisited[];

    public static void dijkstra() {
        distance[0] = 0;

        // for (Road c : connection[0]) {
        //     distance[c.next] = c.time;
        //     pq.add(c);
        // }

        pq.add(new Road(0, 0));
        while (!pq.isEmpty()) {
            Road cur = pq.poll();

            if (isVisited[cur.next]) {
                continue;
            }
            isVisited[cur.next] = true;

            for (Road n : connection[cur.next]) {
                if (distance[n.next] > distance[cur.next] + n.time) {
                    distance[n.next] = distance[cur.next] + n.time;
                    pq.add(new Road(n.next, distance[n.next]));
                }
            }
        }

        if (distance[N - 1] == Long.MAX_VALUE) {
            distance[N - 1] = -1;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        total = 0;

        distance = new long[N];
        connection = new List[N];
        isVisited = new boolean[N];
        isVisible = new HashSet<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            connection[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                isVisible.add(i);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if (canCross(a) && canCross(b)) {
                connection[a].add(new Road(b, t));
                connection[b].add(new Road(a, t));
            }
        }
    }
    
    public static boolean canCross(int a) {
        if (a != N - 1 && isVisible.contains(a)) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        pre();
        dijkstra();
        System.out.println(distance[N-1]);
    }

    static class Road implements Comparable<Road>{
        int next;
        long time;

        public Road() {
        }

        public Road(int next, long time) {
            this.next = next;
            this.time = time;
        }

        @Override
        public int compareTo(Road o) {
            return (int) (this.time - o.time);
        }
    }
}
