import java.io.*;
import java.util.*;

public class boj2075 {
    static int N, result;
    static PriorityQueue<Integer> pq;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0;i<N;i++){
            result = pq.poll();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(result);
    }
}
