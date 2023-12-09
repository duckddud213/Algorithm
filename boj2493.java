import java.io.*;
import java.util.*;

public class boj2493 {
    static int N;
    static Deque<Tower> stack;
    static StringBuilder sb;

    public static void checkSignal(int i,int num) {
        if (stack.isEmpty()) {
            sb.append(0).append(" ");
            stack.add(new Tower(i,num));
            return;
        }

        if (stack.peekLast().height >= num) {
            sb.append(stack.peekLast().i).append(" ");
            stack.add(new Tower(i,num));
        }
        else {
            stack.removeLast();
            checkSignal(i,num);
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        stack = new ArrayDeque<>();
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            checkSignal(i,num);
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.println(sb);
    }

    static class Tower {
        int i, height;

        public Tower() {
        }

        public Tower(int i, int height) {
            this.i=i;
            this.height = height;
        }
    }
}
