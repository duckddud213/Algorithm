import java.io.*;
import java.util.*;

public class boj1368 {
    static int N, cost,min;
    static List<Road> connection[];
    static PriorityQueue<Road> pq;
    static HashSet<Integer> isVisited;

    public static void Prims() {
        for (int i = 1; i <= N; i++) {
            cost = 0;
            pq.clear();
            isVisited.clear();
            
            for (Road r : connection[i]) {
                pq.add(r);
            }
            isVisited.add(i);

            while (!pq.isEmpty() && isVisited.size() < N) {
                Road cur = pq.poll();

                if (isVisited.contains(cur.next)) {
                    continue;
                }

                if (cur.next != 0) {
                    isVisited.add(cur.next);
                }
                cost += cur.cost;

                for (Road n : connection[cur.next]) {
                    pq.add(n);
                }
            }

            min = Integer.min(min, cost);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        cost = 0;

        connection = new List[N + 1];
        pq = new PriorityQueue<>();
        isVisited = new HashSet<>();

        connection[0] = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
            connection[i].add(new Road(0, Integer.parseInt(br.readLine())));
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int price = Integer.parseInt(st.nextToken());
                if (i != j) {
                    connection[i].add(new Road(j, price));
                }
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        Prims();
        System.out.print(min);
    }

    static class Road implements Comparable<Road> {
        int next, cost;

        public Road() {
        }

        public Road(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road O) {
            return this.cost - O.cost;
        }
    }
}