import java.io.*;
import java.util.*;

public class boj11279 {
    static int N;
    static PriorityQueue<Integer> pq;

    public static void main(String args[]) throws IOException {
        int i, input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pq =  new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (pq.size() == 0) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n');
                }
            } else {
                pq.add(input);
            }
        }
        
        System.out.println(sb);
    }
}
