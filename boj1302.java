import java.io.*;
import java.util.*;

public class boj1302 {
    static int N;
    static TreeMap<String, Integer> soldout;
    static PriorityQueue<String> bestsellers;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        soldout = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (soldout.containsKey(input)) {
                soldout.put(input, soldout.get(input) + 1);
            } else {
                soldout.put(input, 1);
            }
        }

        bestsellers = new PriorityQueue<>();
        
        while (!soldout.isEmpty()) {
            System.out.println(soldout.lastEntry());
            soldout.remove(soldout.lastKey());
        }

        // String str = soldout.lastKey();
        // int soldCnt = soldout.get(str);
        // System.out.println(str+" "+soldCnt);
        // soldout.pollLastEntry();
        // bestsellers.add(str);


        // while (!soldout.isEmpty()) {
        //     System.out.println(soldout.lastKey());
        //     if (soldCnt == soldout.get(soldout.lastKey())) {
        //         bestsellers.add(soldout.lastKey());
        //         soldout.pollLastEntry();
        //     }
        //     else {
        //         return;
        //     }
        // }

    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(bestsellers.poll());
    }
}
