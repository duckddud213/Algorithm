import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static boolean isVisited[];
    static int distance[];
    static List<Node>[] graph;
    static PriorityQueue<Node> que;
    static StringBuilder sb;

    public static void dijkstra() {
        que.add(new Node(K, 0));
        distance[K] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();

            isVisited[cur.num] = true;

            for (Node next : graph[cur.num]) {
                if (!isVisited[next.num] && distance[next.num] > cur.dist + next.dist) {
                    distance[next.num] = cur.dist + next.dist;
                    que.add(new Node(next.num, distance[next.num]));
                }
            }
        }
    }

    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        que = new PriorityQueue<>();
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        distance = new int[V + 1];
        isVisited = new boolean[V + 1];
        graph = new ArrayList[V+1];

        for (i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int inputU = Integer.parseInt(st.nextToken());
            int inputV = Integer.parseInt(st.nextToken());
            int inputW = Integer.parseInt(st.nextToken());

            graph[inputU].add(new Node(inputV, inputW));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        dijkstra();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF").append('\n');
            } 
            else {
                sb.append(distance[i]).append('\n');
            }
        }
        System.out.print(sb);
    }
    
    static class Node implements Comparable<Node>{
        int num, dist;

        public Node() {
        }

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}
