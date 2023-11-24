import java.io.*;
import java.util.*;

public class boj11003 {
    static int N, L;
    static Deque<Number> que;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        que = new ArrayDeque<>();

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!que.isEmpty() && que.peekLast().num > num) {
                que.pollLast();
            }
            que.add(new Number(num, i));
            if (que.peek().idx < i - L + 1) { //범위를 벗어난 경우
                que.poll();
            }
            sb.append(que.peek().num).append(" ");
        }

        System.out.print(sb);
    }

    static class Number {
        int num, idx;

        public Number() {
        }

        public Number(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
