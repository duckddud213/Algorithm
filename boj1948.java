import java.io.*;
import java.util.*;

public class boj1948 {
    static int N, M, src, dest,cnt;
    static StringBuilder sb;
    static List<City>[] connection;
    static List<City>[] rConnection;
    static PriorityQueue<City> pq;
    static HashSet<Integer> isVisited;
    static int distance[];

    public static void Dijkstra() {
        pq.add(new City(src, 0));

        while (!pq.isEmpty()) {
            City cur = pq.poll();

            if (cur.weight < distance[cur.next]) {
                continue;
            }

            for (City conn : connection[cur.next]) {
                if (distance[conn.next] < distance[cur.next] + conn.weight) {
                    distance[conn.next] = distance[cur.next] + conn.weight;
                    pq.add(new City(conn.next, distance[conn.next]));
                }
            }
        }

        isVisited.add(dest);
        Deque<Integer> que = new ArrayDeque<>();
        que.add(dest);

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (City nCity : rConnection[cur]) {
                if (distance[cur] - nCity.weight == distance[nCity.next]) {
                    cnt++;
                    if (!isVisited.contains(nCity.next)) {
                        isVisited.add(nCity.next);
                        que.add(nCity.next);
                    }
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cnt = 0;

        connection = new List[N + 1];
        rConnection = new List[N + 1];
        isVisited = new HashSet<>();
        distance = new int[N + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
            rConnection[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            connection[start].add(new City(end, w));
            rConnection[end].add(new City(start, w));
        }

        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
    }

    public static void main(String args[]) throws IOException {
        pre();
        Dijkstra();
        System.out.println(distance[dest]);
        System.out.println(cnt);
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
        public int compareTo(City o) {
            return this.weight - o.weight;
        }
    }
}
