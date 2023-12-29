import java.io.*;
import java.util.*;


public class boj1504 {
    static int N, E, src, dest, sum1,sum2, INF,dist;
    static int distance[];
    static boolean isVisited[];
    static List<Node>[] connection;
    static PriorityQueue<Node> pq;

    public static int Dijkstra(int start,int end) {
        Arrays.fill(distance, INF);
        isVisited = new boolean[N + 1];

        pq.clear();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (isVisited[cur.num]) {
                continue;
            }

            isVisited[cur.num] = true;

            for (Node next : connection[cur.num]) {
                if (!isVisited[next.num] && distance[next.num] > distance[cur.num] + next.weight) {
                    distance[next.num] = distance[cur.num] + next.weight;
                    pq.add(new Node(next.num, distance[next.num]));
                }
            }
        }
        
        return distance[end];
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        INF = 200000000;
        sum1 = 0;
        sum2 = 0;

        connection = new List[N + 1];
        distance = new int[N + 1];
        pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            connection[V].add(new Node(U, W));
            connection[U].add(new Node(V, W));
        }
        st = new StringTokenizer(br.readLine());
        src = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        sum1 += Dijkstra(1, src);
        sum1 += Dijkstra(src, dest);
        sum1 += Dijkstra(dest, N);

        sum2 += Dijkstra(1, dest);
        sum2 += Dijkstra(dest, src);
        sum2 += Dijkstra(src, N);

        dist = (sum1 >= INF && sum2 >= INF) ? -1 : Math.min(sum1, sum2);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(dist);
    }

    static class Node implements Comparable<Node>{
        int num, weight;

        public Node() {
        }

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
