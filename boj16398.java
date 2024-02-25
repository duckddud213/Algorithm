import java.io.*;
import java.util.*;

public class boj16398 {
    static int N;
    static long cost;
    static List<Road> connection[];
    static HashSet<Integer> isVisited;
    static PriorityQueue<Road> pq;

    public static void Prims() {
        isVisited.add(1);
        for (Road r : connection[1]) {
            pq.add(r);
        }

        while (!pq.isEmpty() && isVisited.size() < N) {
            Road cur = pq.poll();

            if (isVisited.contains(cur.next)) {
                continue;
            }

            isVisited.add(cur.next);
            cost += cur.cost;

            for (Road n : connection[cur.next]) {
                pq.add(n);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = 0;

        connection = new List[N + 1];
        isVisited = new HashSet<>();
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                connection[i].add(new Road(j, Integer.parseInt(st.nextToken())));
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        Prims();
        System.out.println(cost);
    }

    static class Road implements Comparable<Road>{
        int next, cost;

        public Road() {
        }

        public Road(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }
    }
}
