import java.io.*;
import java.util.*;

public class boj12851 {
    static int N, K, cnt, shortest;
    static Deque<Dot> que;
    static int time[];

    public static void bfs() {
        que.add(new Dot(N, 0));
        time[N] = 0;

        if (N == K) {
            shortest = 0;
            cnt = 1;
            return;
        }

        while (!que.isEmpty()) {
            Dot queDot = que.pollFirst();

            if (queDot.time > shortest) {
                continue;
            }

            if (isValid(queDot.num - 1)) {
                if (queDot.num - 1 == K) {
                    if (queDot.time + 1 < shortest) {
                        shortest = queDot.time + 1;
                        cnt = 1;
                    } else if (queDot.time + 1 == shortest) {
                        cnt++;
                    }
                } else if (time[queDot.num - 1] == 0 || time[queDot.num - 1] >= queDot.time + 1) {
                    time[queDot.num - 1] = queDot.time + 1;
                    que.add(new Dot(queDot.num - 1, queDot.time + 1));
                }
            }
            if (isValid(queDot.num + 1)) {
                if (queDot.num + 1 == K) {
                    if (queDot.time + 1 < shortest) {
                        shortest = queDot.time + 1;
                        cnt = 1;
                    } else if (queDot.time + 1 == shortest) {
                        cnt++;
                    }
                } else if (time[queDot.num + 1] == 0 || time[queDot.num + 1] >= queDot.time + 1) {
                    time[queDot.num + 1] = queDot.time + 1;
                    que.add(new Dot(queDot.num + 1, queDot.time + 1));
                }
            }
            if (isValid(queDot.num * 2)) {
                if (queDot.num * 2 == K) {
                    if (queDot.time + 1 < shortest) {
                        shortest = queDot.time + 1;
                        cnt = 1;
                    } else if (queDot.time + 1 == shortest) {
                        cnt++;
                    }
                } else if (time[queDot.num * 2] == 0 || time[queDot.num * 2] >= queDot.time + 1) {
                    time[queDot.num * 2] = queDot.time + 1;
                    que.add(new Dot(queDot.num * 2, queDot.time + 1));
                }
            }
        }
    }

    public static boolean isValid(int num) {
        if (num < 0) {
            return false;
        }
        if (num > 100000) {
            return false;
        }
        return true;
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        shortest = Integer.MAX_VALUE;
        cnt = 0;
        time = new int[100001];

        que = new ArrayDeque<>();
    }

    public static void main(String args[]) throws IOException {
        pre();
        bfs();
        System.out.print(shortest + "\n" + cnt);
    }

    static class Dot {
        int num, time;

        public Dot() {
        }

        public Dot(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
