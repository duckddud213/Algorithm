import java.io.*;
import java.util.*;

public class boj10819 {
    static int N, max;
    static int arr[], comb[];
    static boolean isChecked[];

    public static void maxDiff() {
        int sum = 0;

        for (int i = 0; i < N - 1; i++) {
            sum += (int) Math.abs(comb[i] - comb[i + 1]);
        }

        max = Integer.max(max, sum);
    }

    public static void backTracking(int depth) {
        if (depth == N) {
            maxDiff();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                comb[depth] = arr[i];
                backTracking(depth + 1);
                isChecked[i] = false;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        max = 0;

        arr = new int[N];
        comb = new int[N];
        isChecked = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        backTracking(0);
        System.out.println(max);
    }
}
