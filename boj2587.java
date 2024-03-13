import java.io.*;
import java.util.*;

public class boj2587 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int sum = 0;
        int mid = 0;

        for (int i = 0; i < 5; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < 5; i++) {
            int num = pq.poll();
            sum += num;
            if (i == 2) {
                mid = num;
            }
        }

        System.out.println((int) sum / 5);
        System.out.println(mid);

    }
}
