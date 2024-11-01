import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int dist[];
    static boolean isVisited[];
    static List<Node> list[];

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if(!isVisited[cur.dest]){
                isVisited[cur.dest]= true;
            }

            for(Node next : list[cur.dest]){
                if(!isVisited[next.dest] && dist[next.dest] > cur.w + next.w){
                    dist[next.dest] = cur.w + next.w;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        isVisited = new boolean[N + 1];
        list = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        dijkstra();
        System.out.println(dist[N]);
    }

    static class Node implements Comparable<Node> {
        int dest, w;

        public Node(int dest, int w) {
            this.dest = dest;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}