import java.io.*;
import java.util.*;

public class boj2252 {
    static int N, M;
    static int enter[];
    static ArrayDeque<Integer>[] direction;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;

    public static void TopologicalSort() {
        for (int i = 1; i <= N; i++) {
            if (enter[i] == 0) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            int std = pq.poll();
            sb.append(std).append(" ");

            while (!direction[std].isEmpty()) {
                int next = direction[std].poll();
                enter[next]--;
                if (enter[next] == 0) {
                    pq.add(next);
                }
            }
        }

    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        enter = new int[N + 1];
        direction = new ArrayDeque[N + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            direction[i] = new ArrayDeque<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            enter[b]++;
            direction[a].add(b);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        TopologicalSort();
        System.out.println(sb);
    }
}
