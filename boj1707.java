import java.io.*;
import java.util.*;

public class boj1707 {
    static int x, K, V, E;
    static int group[];
    static List<Integer> connection[];
    static Deque<Integer> que;
    static StringBuilder sb;

    public static void bfs() {

        for (int x = 1; x <= V; x++) {
            if (group[x] == 0) {
                group[x] = 1;
                que.add(x);
            }

            while (!que.isEmpty()) {
                int cur = que.poll();

                for (int next : connection[cur]) {
                    if (group[next] == group[cur]) {
                        sb.append("NO").append('\n');
                        return;
                    }

                    if (group[next] == 0) {
                        que.add(next);

                        if (group[cur] == 1) {
                            group[next] = 2;
                        } 
                        else {
                            group[next] = 1;
                        }
                    }
                }
            }
        }
        
        sb.append("YES").append('\n');
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int x = 1; x <= K; x++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            connection = new List[V + 1];
            que = new ArrayDeque<>();

            for (int i = 1; i <= V; i++) {
                connection[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                connection[A].add(B);
                connection[B].add(A);
            }
            
            group = new int[V + 1];
            bfs();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
