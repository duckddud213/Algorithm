import java.io.*;
import java.util.*;

public class boj13913 {
    static int N, K;
    static int visit[], path[];

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visit = new int[100001];
        path = new int[100001];

        Deque<Integer> q = new ArrayDeque<>();
        visit[N] = 1;
        path[N] = N;
        q.offer(N);
        int next;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(visit[cur] - 1);

                Stack<Integer> stack = new Stack<>();
                while (path[cur] != cur) {
                    stack.add(cur);
                    cur = path[cur];
                }
                stack.add(N);

                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty())
                    sb.append(stack.pop() + " ");
                System.out.println(sb);

                return;
            }

            next = cur << 1;
            if (next <= 100000 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                path[next] = cur;
                q.offer(next);
            }

            next = cur + 1;
            if (next <= 100000 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                path[next] = cur;
                q.offer(next);
            }

            next = cur - 1;
            if (next >= 0 && visit[next] == 0) {
                visit[next] = visit[cur] + 1;
                path[next] = cur;
                q.offer(next);
            }

        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
    }
}
