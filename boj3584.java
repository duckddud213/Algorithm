import java.io.*;
import java.util.*;

public class boj3584 {
    static int T, N, a, b, result;
    static StringTokenizer st;
    static int[] tree;
    static HashMap<Integer, Integer> f1, f2;
    static StringBuilder sb;

    public static void findLCA() {
        int val_a, val_b;
        val_a = a;
        val_b = b;
        while (true) {

            if (val_a == val_b) {
                sb.append(val_a).append('\n');
                return;
            }

            if (f1.containsKey(val_b)) {
                sb.append(val_b).append('\n');
                return;
            }
            if (f2.containsKey(val_a)) {
                sb.append(val_a).append('\n');
                return;
            }
            if (!f1.containsKey(val_b) && !f2.containsKey(val_a)) {
                f1.put(val_a, 0);
                f2.put(val_b, 0);
                if (tree[val_a] != 0) {
                    val_a = tree[val_a];
                }
                if (tree[val_b] != 0) {
                    val_b = tree[val_b];
                }
            }

        }
    }

    public static void pre() throws IOException {
        int x, i;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        f1 = new HashMap<>();
        f2 = new HashMap<>();
        sb = new StringBuilder();

        for (x = 1; x <= T; x++) {
            N = Integer.parseInt(br.readLine());
            tree = new int[N + 1];

            for (i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                tree[b] = a; // b의 부모 정보 a 저장
            }


            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            findLCA();

            f1.clear();
            f2.clear();
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}