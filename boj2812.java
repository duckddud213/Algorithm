import java.io.*;
import java.util.*;

public class boj2812 {
    static int N, K, cnt;
    static String num;
    static StringBuilder sb;
    static Deque<Integer> stack;

    public static void greedy() {
        stack.add(Character.getNumericValue(num.charAt(0)));

        for (int i = 1; i < N; i++) {
            int next = Character.getNumericValue(num.charAt(i));
            int top = stack.peekLast();

            if (cnt >= K) {
                stack.add(next);
                continue;
            }

            if (top < next) {
                while (cnt <K && top < next) {
                    cnt++;
                    stack.removeLast();
                    if (stack.isEmpty()) {
                        break;
                    }
                    top = stack.peekLast();
                }
            }

            stack.add(next);
        }

        if (cnt < K) {
            while (cnt < K) {
                stack.removeLast();
                cnt++;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(Integer.toString(stack.poll()));
        }
    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;
        sb = new StringBuilder();

        stack = new ArrayDeque<>();

        num = br.readLine();
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        greedy();
        System.out.println(sb);
    }
}
