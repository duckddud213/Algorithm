import java.io.*;
import java.util.*;

public class Main {
    static int N, M, sum;
    static List<Node> graph[];
    static PriorityQueue<Node> pq;
    static HashSet<Integer> connected;

    public static void Prims() {

        for(Node init : graph[1]){
            pq.add(init);
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(connected.contains(cur.src) && connected.contains(cur.dest)){
                continue;
            }

            connected.add(cur.src);
            connected.add(cur.dest);
            sum += cur.cost;

            // for(Node next : graph[cur.src]){
            //     if(!connected.contains(next.dest)){
            //         pq.add(next);
            //     }
            // }

            for(Node next : graph[cur.dest]){
                if(!connected.contains(next.dest)){
                    pq.add(next);
                }
            }            
        }
    }

    public static void inputs() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        sum = 0;

        graph = new List[N + 1];
        pq = new PriorityQueue<>();
        connected = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int inputA = Integer.parseInt(st.nextToken());
            int inputB = Integer.parseInt(st.nextToken());
            int inputW = Integer.parseInt(st.nextToken());

            graph[inputA].add(new Node(inputA, inputB, inputW));
            graph[inputB].add(new Node(inputB, inputA, inputW));
        }
    }

    public static void main(String args[]) throws IOException {
        inputs();
        Prims();
        System.out.println(sum);
    }

    static class Node implements Comparable<Node> {
        int src, dest, cost;

        public Node(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
