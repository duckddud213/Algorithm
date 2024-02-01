import java.io.*;
import java.util.*;

public class boj2776 {
    static int x,T,N, M;
    static HashSet<Integer> hset;
    static StringBuilder sb;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        hset = new HashSet<>();

        for (x = 1; x <= T; x++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            hset.clear();

            for (int i = 0; i < N; i++) {
                hset.add(Integer.parseInt(st.nextToken()));
            }

            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < M; i++) {
                sb.append(hset.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append('\n');
            }
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
