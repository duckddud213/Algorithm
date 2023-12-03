import java.io.*;
import java.util.*;

public class boj1325 {
    
    static StringBuilder sb;
    static int N, M;
    static List<List<Integer>> adj;
    static boolean[] visited;
    static int[] count;
    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void print(Queue<Integer> result) {
        while (!result.isEmpty()) {
            sb.append(result.poll()).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void solve() throws IOException {
        init();
        Queue<Integer> result = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            dfs(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++){
            if (max < count[i]) {
                max = count[i];
                result.clear();
                result.offer(i);
            } else if (max == count[i]) {
                result.offer(i);
            }
        }

        print(result);
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for (int next: adj.get(cur)) {
            if (visited[next]) continue;
            count[next]++;
            dfs(next);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        visited = new boolean[N + 1];
        count = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
        }


    }
}