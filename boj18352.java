import java.io.*;
import java.util.*;

public class boj18352 {
    static int N, M, K, X, INF, cnt;
    static PriorityQueue<Integer> result;
    static PriorityQueue<Node> que;
    static List<Integer>[] connection;
    static HashSet<Integer> isVisited;
    static int[] distance;
    static StringBuilder sb;

    public static void dijkstra() {
        distance[X] = 0;

        que.add(new Node(X, 0));

        while (!que.isEmpty() && isVisited.size()<N) {
            Node cur = que.poll();

            if (isVisited.contains(cur.num)) {
                continue;
            }

            isVisited.add(cur.num);

            for (int i : connection[cur.num]) {
                if (distance[i] > distance[cur.num] + 1) {
                    distance[i] = distance[cur.num] + 1;
                    que.add(new Node(i, distance[i]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (K == distance[i]) {
                result.add(i);
                cnt++;
            }
        }

        while (!result.isEmpty()) {
            sb.append(result.poll()).append('\n');
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        INF = 300001;
        cnt = 0;

        result = new PriorityQueue<>();
        que = new PriorityQueue<>();
        connection = new List[N + 1];
        distance = new int[N + 1];
        isVisited = new HashSet<>();
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            connection[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connection[a].add(b);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        dijkstra();
        System.out.print(cnt == 0 ? -1 : sb);
    }

    static class Node implements Comparable<Node> {
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
