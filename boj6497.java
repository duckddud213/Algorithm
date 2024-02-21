import java.io.*;
import java.util.*;

public class boj6497 {
    static int N, M, cost, T, total;
    static List<Road> connection[];
    static PriorityQueue<Road> pq;
    static HashSet<Integer> isVisited;
    static StringBuilder sb;

    public static void Prims() {

        isVisited.add(0);
        for (Road r : connection[0]) {
            pq.add(r);
        }

        while (!pq.isEmpty() && isVisited.size() < M) {
            Road cur = pq.poll();

            if (isVisited.contains(cur.next)) {
                continue;
            }

            isVisited.add(cur.next);
            cost += cur.weight;

            for (Road r : connection[cur.next]) {
                pq.add(r);
            }
        }

        total -= cost;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (M == 0 && N == 0) {
                return;
            }

            cost = 0;
            total = 0;

            pq = new PriorityQueue<>();
            connection = new List[M];
            isVisited = new HashSet<>();

            for (int i = 0; i < M; i++) {
                connection[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                connection[x].add(new Road(y, z));
                connection[y].add(new Road(x, z));
                total += z;
            }

            Prims();
            sb.append(total).append('\n');
        }

    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }

    static class Road implements Comparable<Road> {
        int next, weight;

        public Road() {
        }

        public Road(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        public int compareTo(Road o) {
            return this.weight - o.weight;
        }
    }
}