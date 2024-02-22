import java.io.*;
import java.util.*;

public class boj14621 {
    static int N, M, src, dist;
    static HashMap<Integer, String> gender;
    static List<Road> connection[];
    static PriorityQueue<Road> pq;
    static HashSet<Integer> isVisited;

    public static void Prims() {
        for (Road r : connection[src]) {
            pq.add(r);
        }
        isVisited.add(src);

        while (!pq.isEmpty() && isVisited.size() < N) {
            Road cur = pq.poll();

            if (isVisited.contains(cur.next)) {
                continue;
            }

            isVisited.add(cur.next);
            dist += cur.weight;

            for (Road c : connection[cur.next]) {
                pq.add(c);
            }
        }

        if (isVisited.size() != N) {
            dist = -1;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int u,v,d;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = 0;
        u = -1;

        st = new StringTokenizer(br.readLine());
        gender = new HashMap<>();
        connection = new List[N + 1];
        isVisited = new HashSet<>();
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            gender.put(i, st.nextToken());
            connection[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (!gender.get(u).equals(gender.get(v))) {
                connection[u].add(new Road(v, d));
                connection[v].add(new Road(u, d));
            }
        }

        src = u;
    }

    public static void main(String args[]) throws IOException {
        pre();
        Prims();
        System.out.println(dist);
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
        public int compareTo(Road O) {
            return this.weight - O.weight;
        }
    }
}