import java.io.*;
import java.util.*;

public class boj13904 {
    static int N, d, w, total;
    static PriorityQueue<Homework> pq;

    public static void greedy() {
        int check[] = new int[1001];

        while (!pq.isEmpty()) {
            Homework cur = pq.poll();
            for (int i = cur.due; i > 0; i--) {
                if (check[i] == 0) {
                    check[i] = cur.score;
                    break;
                }
            }
        }

        for (int num : check) {
            total += num;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        total = 0;
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            pq.add(new Homework(d, w));
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        greedy();
        System.out.println(total);
    }

    static class Homework implements Comparable<Homework> {
        int due, score;

        public Homework() {
        }

        public Homework(int due, int score) {
            this.due = due;
            this.score = score;
        }

        @Override
        public int compareTo(Homework o) {
            if (this.score == o.score) {
                return this.due - o.due;
            }

            return o.score - this.score;            
        }
    }
}
