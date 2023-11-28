import java.io.*;
import java.util.*;

public class boj4386 {
    static int N;
    static Double sum;
    static Double star[][];
    static Deque<Connection> line[];
    static HashSet<Integer> stellar;
    static PriorityQueue<Connection> pq;

    public static void Prim() {
        pq.add(new Connection(1, 0.0));

        while (!pq.isEmpty()) {
            Connection con = pq.poll();
            if (stellar.contains(con.num)) {
                continue;
            }
            stellar.add(con.num);
            sum += con.dist;

            while (!line[con.num].isEmpty()) {
                Connection next = line[con.num].poll();

                if (!stellar.contains(next.num)) {
                    pq.add(next);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sum = 0.0;

        star = new Double[N + 1][2];
        line = new Deque[N + 1];
        stellar = new HashSet<>();
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            star[i][0] = Double.parseDouble(st.nextToken());
            star[i][1] = Double.parseDouble(st.nextToken());

            line[i] = new ArrayDeque<>();
            for (int j = 1; j < i; j++) {
                Double dist = Math.sqrt(Math.pow(star[i][0] - star[j][0], 2) + Math.pow(star[i][1] - star[j][1], 2));
                line[i].add(new Connection(j, dist));
                line[j].add(new Connection(i, dist));
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        Prim();
        System.out.printf("%.2f",sum);
    }

    static class Connection  implements Comparable<Connection>{
        int num;
        Double dist;

        public Connection() {
        }

        public Connection(int num, Double dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Connection o) {
            if (this.dist > o.dist) {
                return 1;
            }
            else
                return -1;
        }
    }
}