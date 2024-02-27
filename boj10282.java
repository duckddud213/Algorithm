import java.io.*;
import java.util.*;

public class boj10282 {
    static int x, T, N, D, C, infected, time, INF;
    static int distance[];
    static List<Computer> connection[];
    static PriorityQueue<Computer> pq;
    static StringBuilder sb;

    public static void dijkstra() {
        for (Computer con : connection[C]) {
            distance[con.next] = con.time;
            pq.add(con);
        }

        while (!pq.isEmpty()) {
            Computer cur = pq.poll();

            for (Computer next : connection[cur.next]) {
                if (distance[next.next] > next.time+distance[cur.next]) {
                    distance[next.next] = next.time+distance[cur.next];
                    pq.add(new Computer(next.next, distance[next.next]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i] != INF) {
                infected++;
                time = Integer.max(time, distance[i]);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        INF = 10000001;
        sb = new StringBuilder();

        for (int x = 0; x < T; x++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            infected = 0;
            time = Integer.MIN_VALUE;

            connection = new List[N + 1];
            distance = new int[N + 1];
            pq = new PriorityQueue<>();

            for (int i = 1; i <= N; i++) {
                connection[i] = new ArrayList<>();
                distance[i] = INF;
            }

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                connection[b].add(new Computer(a, s));
            }

            distance[C] = 0;

            dijkstra();
            
            sb.append(infected).append(" ").append(time).append('\n');
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }

    static class Computer implements Comparable<Computer>{
        int next, time;

        public Computer() {
        }

        public Computer(int next, int time) {
            this.next = next;
            this.time = time;
        }

        @Override
        public int compareTo(Computer o) {
            return this.time - o.time;
        }
    }
}
