import java.io.*;
import java.util.*;

public class boj1766 {
    static int N, M;
    static int presolve[];
    static ArrayDeque<Integer>[] direction;
    static PriorityQueue<Integer> prob;
    static StringBuilder sb;

    public static void TopologicalSort() {
        for (int i = 1; i <= N; i++) {
            if (presolve[i] == 0) {
                prob.add(i);
            }
        }

        while (!prob.isEmpty()) {
            int solved = prob.poll();
            sb.append(solved).append(" ");

            while (!direction[solved].isEmpty()) {
                int question = direction[solved].poll();
                presolve[question]--;
                
                if (presolve[question] == 0) {
                    prob.add(question);
                }
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        presolve = new int[N + 1];
        direction = new ArrayDeque[N + 1];
        prob = new PriorityQueue<Integer>();
        sb = new StringBuilder();
        
        for (int i = 0; i <= N; i++) {
            direction[i] = new ArrayDeque<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());

            direction[V].add(U);
            presolve[U]++;
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        TopologicalSort();
        System.out.println(sb);
    }
}