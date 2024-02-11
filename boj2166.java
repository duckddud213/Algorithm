import java.io.*;
import java.util.*;

public class boj2166 {
    static int N;
    static long sum;
    static Pos dots[];

    public static void counterClockWise() {
        for (int i = 0; i < N; i++) {
            sum += (dots[i].x * dots[i + 1].y - dots[i + 1].x * dots[i].y);
        }

        sum = Math.abs(sum);

        System.out.printf("%.1f", sum * 0.5);
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sum = 0;
        dots = new Pos[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dots[i] = new Pos(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        dots[N] = dots[0];
    }

    public static void main(String args[]) throws IOException {
        pre();
        counterClockWise();
    }

    static class Pos {
        long x, y;

        public Pos() {
        }

        public Pos(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
