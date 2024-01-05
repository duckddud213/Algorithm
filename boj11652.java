import java.io.*;
import java.util.*;

public class boj11652 {
    static int N, max;
    static HashMap<Long, Integer> deck;
    static List<Integer> list;
    static PriorityQueue<Long> pq;
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        deck = new HashMap<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            deck.put(num, deck.getOrDefault(num, 0) + 1);
        }

        max = 0;
        list = new ArrayList<>(deck.values());
        for (int val : list) {
            max = Math.max(max, val);
        }

        for (Long key : deck.keySet()) {
            if (max == deck.get(key)) {
                pq.add(key);
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(pq.poll());
    }
}
