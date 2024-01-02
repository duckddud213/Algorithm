import java.io.*;
import java.util.*;

public class boj17219 {
    static int N, M;
    static HashMap<String, String> info;
    static StringBuilder sb;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String name, password;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new HashMap<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            password = st.nextToken();

            info.put(name, password);
        }

        for (int i = 0; i < M; i++) {
            name = br.readLine();
            sb.append(info.get(name)).append('\n');
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}
