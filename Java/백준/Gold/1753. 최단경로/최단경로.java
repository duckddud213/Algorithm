import java.io.*;
import java.util.*;

public class Main {
    static int V, E, K;
    static int distance[];
    static boolean isChecked[];
    static List<Node> line[];
    static StringBuilder sb;

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(K, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            isChecked[cur.num] = true;

            for (Node next : line[cur.num]) {
                if (!isChecked[next.num] && distance[next.num] > cur.dist + next.dist) {
                    distance[next.num] = cur.dist + next.dist;
                    pq.add(new Node(next.num, distance[next.num]));
                }
            }
        }

        for(int i = 1; i <= V;i++){
            if(i == K){
                sb.append("0").append("\n");
            }
            else if(distance[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }
            else{
                sb.append(distance[i]).append("\n");
            }
        }
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        line = new List[V + 1];
        distance = new int[V + 1];
        isChecked = new boolean[V + 1];
        sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            line[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int inputV = Integer.parseInt(st.nextToken());
            int inputE = Integer.parseInt(st.nextToken());
            int inputK = Integer.parseInt(st.nextToken());

            line[inputV].add(new Node(inputE, inputK));
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        dijkstra();
        System.out.print(sb);
    }

    static class Node implements Comparable<Node> {
        int num, dist;

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
