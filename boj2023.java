import java.io.*;
import java.util.*;

public class boj2023 {
    static int N, src, dest;
    static StringBuilder sb;

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void backtracking(int depth, int num) {
        if (depth == N) {
            sb.append(num).append('\n');

            return;
        }

        for (int i = 1; i <= 9; i++) {
            int next = num * 10 + i;

            if (isPrime(next)) {
                backtracking(depth+1, next);
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
    }

    public static void main(String args[]) throws IOException {
        pre();
        backtracking(0, 0);
        System.out.println(sb);
    }
}
