import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int inorder[], inIdx[], postorder[];
    static StringBuilder sb = new StringBuilder();

    public static void solve(int is, int ie, int ps, int pe) {
        if (ie < is || pe < ps) {
            return;
        }
        int root = postorder[pe];
        int rIdx = inIdx[root];
        sb.append(root + " ");

        int len = rIdx - is;
        solve(is, rIdx - 1, ps, ps + len - 1);
        solve(rIdx + 1, ie, ps + len, pe - 1);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        inorder = new int[N + 1];
        postorder = new int[N + 1];
        inIdx = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            inIdx[inorder[i]] = i;
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        solve(1, N, 1, N);
        System.out.println(sb);
    }
}