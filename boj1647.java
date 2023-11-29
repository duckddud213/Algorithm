import java.io.*;
import java.util.*;

public class boj1647 {
    static int N, M, sum, size, result;
    static HashSet<Integer> group;
    static PriorityQueue<Connection> pq;
    static Deque<Connection>[] line;
    static int[] separateSum;

    public static void Prim() {
        pq.add(new Connection(1, 0));

        while (!pq.isEmpty()) {
            Connection que = pq.poll();

            if (group.contains(que.next)) {
                continue;
            }

            group.add(que.next);
            separateSum[size] = separateSum[size - 1] + que.weight;
            size++;

            while (!line[que.next].isEmpty()) {
                Connection linked = line[que.next].poll();

                if (!group.contains(linked.next)) {
                    pq.add(linked);
                }
            }
        }

        sum = separateSum[N];

        for (int i = 2; i <= N; i++) {
            result = Integer.min(result, sum - (separateSum[i] - separateSum[i - 1]));
        }

    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = 0;
        size = 1;
        result = Integer.MAX_VALUE;

        group = new HashSet<>();
        pq = new PriorityQueue<>();
        line = new Deque[N + 1];
        separateSum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            line[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            line[V].add(new Connection(U, W));
            line[U].add(new Connection(V, W));
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        Prim();
        System.out.println(result);
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
