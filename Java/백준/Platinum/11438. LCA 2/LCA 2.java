import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static int depth[];
    static int parent[][];
    static List<Integer> list[];
    static StringBuilder sb;

    public static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        if (ah < bh) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = H - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[a][i];
            }
        }

        if (a == b)
            return a;

        for (int i = H - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }

    public static void fillParents() {
        for (int i = 1; i < H; i++) {
            for (int j = 1; j <= N; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    public static void init(int cur, int height, int p) {
        depth[cur] = height;
        for (int next : list[cur]) {
            if (next != p) {
                init(next, height + 1, cur);
                parent[next][0] = cur;
            }
        }
    }

    public static void getTreeHeight() {
        H = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        list = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        getTreeHeight();

        depth = new int[N + 1];
        parent = new int[N + 1][H];

        init(1, 1, 0);
        fillParents();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
