import java.io.*;
import java.util.*;

public class boj1922 {
    static int N, M,distance;
    static HashSet<Integer> isConnected;
    static PriorityQueue<Connection> pq;
    static List<Connection>[] conn;

    public static void Prims() {
        isConnected.add(1);
        for (Connection next : conn[1]) {
            pq.add(next);
        }

        while (!pq.isEmpty()) {
            Connection next = pq.poll();

            if (isConnected.contains(next.next)) {
                continue;
            }
            isConnected.add(next.next);
            distance += next.weight;

            for (Connection x : conn[next.next]) {
                pq.add(x);
            }
        }
    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = 0;

        isConnected = new HashSet<>();
        pq = new PriorityQueue<>();
        conn = new List[N + 1];
        
        for (int i = 1; i <= N; i++) {
            conn[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            conn[V].add(new Connection(U, W));
            conn[U].add(new Connection(V, W));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        Prims();
        System.out.println(distance);
    }

    static class Connection implements Comparable<Connection> {
        int next, weight;

        public Connection() {
        }

        public Connection(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Connection o) {
            return this.weight - o.weight;
        }
    }
}
