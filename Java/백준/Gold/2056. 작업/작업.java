import java.io.*;
import java.util.*;

public class Main {
    static int N, sum;
    static int inline[], time[];
    static List<Integer> list[];
    static PriorityQueue<Job> pq;

    public static void TopologicalSort() {
        while (!pq.isEmpty()) {
            Job cur = pq.poll();

            sum = Math.max(sum, cur.finished);

            for (int next : list[cur.num]) {
                inline[next]--;

                if (inline[next] == 0) {
                    pq.add(new Job(next, cur.finished + time[next]));
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sum = 0;
        inline = new int[N + 1];
        time = new int[N + 1];
        list = new List[N + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            inline[i] = Integer.parseInt(st.nextToken());

            if (inline[i] == 0) {
                pq.add(new Job(i, time[i]));
            }

            while (st.hasMoreTokens()) {
                list[Integer.parseInt(st.nextToken())].add(i);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        TopologicalSort();
        System.out.println(sum);
    }

    static class Job implements Comparable<Job> {
        int num, finished;

        public Job(int num, int finished) {
            this.num = num;
            this.finished = finished;
        }

        @Override
        public int compareTo(Job o) {
            return this.finished - o.finished;
        }
    }
}