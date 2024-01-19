import java.io.*;
import java.util.*;

public class boj9019 {
    static int x, T, src, dest;
    static boolean isVisited[];
    static StringBuilder sb;
    static Deque<Register> que;

    public static void bfs() {
        
        isVisited[src] = true;
        que.add(new Register(src, ""));

        while (!que.isEmpty()) {
            Register cur = que.poll();

            if (cur.num == dest) {
                sb.append(cur.command).append('\n');
                return;
            }

            if (!isVisited[cur.D()]) {
                que.add(new Register(cur.D(), cur.command + "D"));
                isVisited[cur.D()] = true;
            }
            if (!isVisited[cur.S()]) {
                que.add(new Register(cur.S(), cur.command + "S"));
                isVisited[cur.S()] = true;
            }
            if (!isVisited[cur.L()]) {
                que.add(new Register(cur.L(), cur.command + "L"));
                isVisited[cur.L()] = true;
            }
            if (!isVisited[cur.R()]) {
                que.add(new Register(cur.R(), cur.command + "R"));
                isVisited[cur.R()] = true;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        que = new ArrayDeque<>();

        for (int x = 1; x <= T; x++) {
            isVisited = new boolean[10000];
            que.clear();
            st = new StringTokenizer(br.readLine());
            src = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());
            bfs();
        }
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        System.out.print(sb);
    }

    static class Register {
        int num;
        String command;

        public Register() {
        }

        public Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num / 10;
        }
    }
}
