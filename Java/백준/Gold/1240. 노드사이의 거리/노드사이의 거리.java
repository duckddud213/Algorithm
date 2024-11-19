import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Node> dist[];
    static StringBuilder sb;

    public static void dfs(int src, int dest, int prev, int cur, int sum) {
        if (cur == dest) {
            sb.append(sum).append('\n');
            return;
        }

        for (Node next : dist[cur]) {
            if (next.dest != src && next.dest != prev) {
                dfs(src, dest, cur, next.dest, sum + next.d);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            dist[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dist[a].add(new Node(b, d));
            dist[b].add(new Node(a, d));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            dfs(src, dest, 0, src, 0);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }

    static class Node {
        int dest, d;

        public Node(int dest, int d) {
            this.dest = dest;
            this.d = d;
        }
    }
}