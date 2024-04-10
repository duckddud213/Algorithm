import java.io.*;
import java.util.*;

public class boj18870 {
    static int N;
    static int pos[];
    static HashMap<Integer, Integer> order;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;

    public static void comp() {
        int cnt = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll();

            if (!order.containsKey(cur)) {
                order.put(cur, cnt);
                cnt++;
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(order.get(pos[i])).append(" ");
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pos = new int[N];
        order = new HashMap<>();
        pq = new PriorityQueue<>();
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
            pq.add(pos[i]);
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        comp();
        System.out.println(sb);
    }
}
