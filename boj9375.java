import java.util.*;
import java.io.*;

public class boj9375 {
    static int tc, T, N, ans;
    static HashMap<String, Integer> mm;
    static StringBuilder sb;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            mm = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                mm.put(type, mm.getOrDefault(type, 0) + 1);
            }

            ans = 1;
            for (int val : mm.values()) {
                ans *= val + 1;
            }
            sb.append(ans - 1).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        pre();
        System.out.print(sb);
    }
}