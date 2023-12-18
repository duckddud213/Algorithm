import java.io.*;
import java.util.*;

public class boj5430 {
    static int x, T, N;
    static String p, input;
    static boolean isReverse;
    static StringBuilder sb;
    static Deque<String> que;

    public static void AC() {
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == 'R') {
                isReverse = !isReverse;
            } 
            else if (p.charAt(i) == 'D') {
                if (que.size() == 0) {
                    sb.append("error").append('\n');
                    return;
                } 
                else {
                    if (isReverse) {
                        que.removeLast();
                    }
                    else {
                        que.remove();
                    }
                }
            }
        }
        
        if (que.size() == 0) {
            sb.append("[]").append('\n');
            return;
        }

        sb.append('[');
        while (que.size() != 1) {
            if (isReverse) {
                sb.append(que.pollLast()).append(',');
            } 
            else {
                sb.append(que.poll()).append(',');
            }
        }
        sb.append(que.poll()).append(']').append('\n');

    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        que = new ArrayDeque<>();
        StringTokenizer st;

        for (x = 1; x <= T; x++) {
            p = br.readLine();
            N = Integer.parseInt(br.readLine());
            input = br.readLine();
            isReverse = false;
            que.clear();

            st = new StringTokenizer(input, "[,]");

            while (st.hasMoreTokens()) {
                que.add(st.nextToken());
            }

            AC();
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }
}