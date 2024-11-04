import java.io.*;
import java.util.*;

public class Main {
    static int N, M, h, size, result;
    static int num[], tree[];
    static StringBuilder sb;

    public static void getMin(int src, int dest, int node, int l, int r) {
        if (dest < l || r < src) {
            return;
        }

        if (l <= src && dest <= r) {
            result = Math.min(result, tree[node]);
            return;
        }

        int m = (src + dest) / 2;
        getMin(src, m, node * 2, l, r);
        getMin(m + 1, dest, node * 2 + 1, l, r);
    }

    public static void init(int src, int dest, int node) {
        if (src == dest) {
            tree[node] = num[src];
        }
        else {
            int m = (src + dest) / 2;

            init(src, m, node * 2);
            init(m + 1, dest, node * 2 + 1);

            if (tree[node * 2] < tree[node * 2 + 1]) {
                tree[node] = tree[node * 2];
            }
            else {
                tree[node] = tree[node * 2 + 1];
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        h = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
        size = (int) Math.pow(2, h);

        num = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        tree = new int[size];
        init(1, N, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result = Integer.MAX_VALUE;
            getMin(1, N, 1, a, b);
            sb.append(result).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}