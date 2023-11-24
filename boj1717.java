import java.io.*;
import java.util.*;

public class boj1717 {

    static int n, m, cal, a, b;
    static int parent[];
    static StringBuilder sb;

    public static int find(int k) {
        if (k != parent[k]) {
            parent[k] = find(parent[k]);
        }
        return parent[k];
    }

    public static void combineSet(int a, int b) {
        if (find(a) > find(b)) {
            parent[parent[a]] = parent[b];
        } else if (parent[b] >parent[a]) {
            parent[parent[b]] = parent[a];
        }
    }

    public static void checkSet(int a, int b) {
        if (find(a) == find(b)) {
            sb.append("YES").append('\n');
        } else {
            sb.append("NO").append('\n');
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        parent = new int[1000001];

        for (int i = 0; i <= 1000000; i++) {
            parent[i] = i;
        }

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cal = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (cal == 0) {
                combineSet(a, b);
            } else if (cal == 1) {
                checkSet(a, b);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
