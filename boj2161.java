import java.io.*;
import java.util.*;

public class boj2161 {
    static int N;
    static Deque<Integer> que;
    static StringBuilder sb;

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        que = new ArrayDeque<>();

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            que.add(i);
        }

        while (que.size() > 1) {
            sb.append(que.poll()).append(" ");
            que.add(que.poll());
        }
        sb.append(que.poll());
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }
}
