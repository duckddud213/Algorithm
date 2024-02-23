import java.io.*;
import java.util.*;

public class boj10423 {
    static int N, M, K, cost;
    static TreeSet<Integer> plant;
    static List<Road> connection[];
    static PriorityQueue<Road> pq;
    static HashSet<Integer> isVisited;

    public static void Prims() {
        for (int pl : plant) {
            for (Road con : connection[pl]) {
                pq.add(con);
            }
            isVisited.add(pl);
        }

        while (!pq.isEmpty() && isVisited.size() < N) {
            Road cur = pq.poll();

            if (isVisited.contains(cur.next)) {
                continue;
            }

            isVisited.add(cur.next);
            cost += cur.weight;

            for (Road nextRoad : connection[cur.next]) {
                pq.add(nextRoad);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cost = 0;

        connection = new List[N + 1];
        plant = new TreeSet<>();
        pq = new PriorityQueue<>();
        isVisited = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            plant.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            connection[u].add(new Road(v, d));
            connection[v].add(new Road(u, d));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        Prims();
        System.out.println(cost);
    }

    static class Road implements Comparable<Road> {
        int next, weight;

        public Road() {
        }

        public Road(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight - o.weight;
        }
    }
}
