import java.io.*;
import java.util.*;

public class boj11779 {
    static int N, M,src,dest;
    static List<City>[] connection;
    static int distance[];
    static int prev[];
    static PriorityQueue<City> pq;
    static Deque<Integer> que;
    static StringBuilder sb;
    
    public static void Dijkstra() {
        boolean isVisited[] = new boolean[N + 1];
        distance[src] = 0;

        pq.add(new City(src, 0));
        isVisited[src] = true;

        while (!pq.isEmpty()) {
            City cur = pq.poll();
            isVisited[cur.next] = true;
            if (distance[cur.next] < cur.weight) {
                continue;
            }
            if (dest == cur.next) {
                break;
            }

            for (City conn : connection[cur.next]) {
                if (!isVisited[conn.next] && distance[conn.next] > cur.weight + conn.weight) {
                    distance[conn.next] = cur.weight + conn.weight;
                    pq.add(new City(conn.next, distance[conn.next]));
                    prev[conn.next] = cur.next;
                }
            }
        }
        sb.append(distance[dest]).append('\n');

        int track = dest;
        while (track != 0) {
            que.add(track);
            track = prev[track];
        }

        sb.append(que.size()).append('\n');
        while (!que.isEmpty()) {
            sb.append(que.pollLast()).append(" ");
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        connection = new List[N + 1];
        distance = new int[N + 1];
        prev = new int[N + 1];
        que = new ArrayDeque<>();
        pq = new PriorityQueue<>();
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            connection[V].add(new City(U, W));
        }

        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
    }

    public static void main(String args[]) throws IOException {
        pre();
        Dijkstra();
        System.out.print(sb);
    }

    static class City implements Comparable<City> {
        int next, weight;

        public City() {
        }

        public City(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(City O) {
            return this.weight - O.weight;
        }
    }
}
