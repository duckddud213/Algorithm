import java.io.*;
import java.util.*;

public class boj1202 {
    static int N, K;
    static long ans;
    static Gem gems[];
    static int bag[];
    static PriorityQueue<Integer> pq;

    public static void stealMax() {
        int i, j;

        j = 0;
        for (i = 0; i < K; i++) {
            while (j < N && gems[j].mass <= bag[i]) {
                pq.add(gems[j].price);
                j++;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;

        gems = new Gem[N];
        bag = new int[K];
        pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i] = new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(gems);

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
    }

    public static void main(String args[]) throws IOException {
        pre();
        stealMax();
        System.out.println(ans);
    }

    static class Gem implements Comparable<Gem> {
        int mass, price;

        public Gem() {
        }

        public Gem(int mass, int price) {
            this.mass = mass;
            this.price = price;
        }

        @Override
        public int compareTo(Gem o) {
            if (this.mass == o.mass) {
                return o.price - this.price;
            }

            return this.mass - o.mass;
        }
    }
}
