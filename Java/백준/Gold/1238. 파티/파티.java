import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X;
    static ArrayList<Node> goX[];
    static ArrayList<Node> leaveX[];
    
    public static int[] dijkstra(List<Node>[] list, int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean isVisited[] = new boolean[N + 1];
        int distance[] = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        pq.add(new Node(src, 0));
        isVisited[src]=true;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            isVisited[cur.num] = true;

            for (Node next : list[cur.num]) {
                if (!isVisited[next.num] && distance[next.num] > cur.w + next.w) {
                    distance[next.num] = cur.w + next.w;
                    pq.add(new Node(next.num, distance[next.num]));
                }
            }
        }

        return distance;
    }

    public static void pre() throws IOException {
        int i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        goX = new ArrayList[N + 1];
        leaveX = new ArrayList[N + 1];

        for (i = 1; i <= N; i++) {
            goX[i] = new ArrayList<>();
            leaveX[i] = new ArrayList<>();
        }

        for (i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int inputU = Integer.parseInt(st.nextToken());
            int inputV = Integer.parseInt(st.nextToken());
            int inputW = Integer.parseInt(st.nextToken());

            goX[inputV].add(new Node(inputU, inputW));
            leaveX[inputU].add(new Node(inputV, inputW));
        }
    }

    public static int findLongest() {
        int go[] = dijkstra(goX, X);
        int leave[] = dijkstra(leaveX, X);

        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, go[i] + leave[i]);
        }

        return result;
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(findLongest());
    }

    static class Node implements Comparable<Node> {
        int num, w;
        
        public Node() {
        }

        public Node(int num, int w) {
            this.num = num;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}
