import java.io.*;
import java.util.*;

public class boj1806 {
    static int N, S, pi, pj, min, sum;
    static int[] arr;

    public static void twoPointer() {
        pi = 0;
        pj = 0;
        sum = 0;

        while (pi <= pj && pj <= N) {
            if (sum < S) {
                sum += arr[pj];
                pj++;
            }
            else {
                min = Math.min(min, pj - pi);
                sum -= arr[pi];
                pi++;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        sum = 0;
        min = Integer.MAX_VALUE;

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String args[]) throws IOException {
        pre();
        twoPointer();
        System.out.println(min==Integer.MAX_VALUE?0:min);
    }
}
