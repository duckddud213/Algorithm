import java.io.*;
import java.util.*;

public class boj1715 {
    static int N, sum;
    static PriorityQueue<Integer> pq;

    public static void checkMin() {
        if (N == 1) {
            sum = 0;
            return;
        }
        else if (N == 2) {
            sum = pq.poll() + pq.poll();
            return;
        }

        while (pq.size() > 1) {
            int newCard = pq.poll() + pq.poll();
            sum += newCard;
            pq.add(newCard);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sum = 0;
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
    }
    
    public static void main(String args[]) throws IOException{
        pre();
        checkMin();
        System.out.println(sum);
    }
}
