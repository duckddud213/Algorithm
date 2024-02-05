import java.io.*;
import java.util.*;

public class boj1417 {
    static int N, voted,cnt;
    static PriorityQueue<Integer> pq;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq = new PriorityQueue<>(Collections.reverseOrder());

        N = Integer.parseInt(br.readLine());
        voted = Integer.parseInt(br.readLine());

        for (int i = 1; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        cnt = 0;
        while (!pq.isEmpty() && pq.peek() >= voted) {
            int cur = pq.poll();
            voted++;
            cnt++;
            pq.add(cur - 1);
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(cnt);
    }
}
