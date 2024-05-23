import java.io.*;
import java.util.*;

public class boj2660 {
    static int N, max, score, cnt;
    static int INF = 1000000;
    static int dist[][];
    static PriorityQueue<Friendship> pq;
    static StringBuilder sb;
    static List<Integer> member;

    public static void selectRepresentative() {
        for (int i = 1; i <= N; i++) {
            max = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    max = Math.max(max, dist[i][j]);
                }
            }

            pq.add(new Friendship(i, max));
        }

        Friendship first = pq.peek();
        score = first.score;
        cnt = 0;

        while (!pq.isEmpty()) {
            Friendship cur = pq.poll();
            if (cur.score == score) {
                cnt++;
                member.add(cur.num);
            } 
            else {
                break;
            }
        }

        Collections.sort(member);

        sb.append(score).append(" ").append(cnt).append('\n');

        for (int next : member) {
            sb.append(next).append(" ");
        }
    }

    public static void FloydWrasahll() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (i != k) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        pq = new PriorityQueue<>();
        member = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            dist[a][b] = 1;
            dist[b][a] = 1;
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        FloydWrasahll();
        selectRepresentative();
        System.out.println(sb);
    }

    static class Friendship implements Comparable<Friendship> {
        int num, score;

        public Friendship() {
        }

        public Friendship(int num, int score) {
            this.num = num;
            this.score = score;
        }

        public int compareTo(Friendship o) {
            return this.score - o.score;
        }
    }
}
