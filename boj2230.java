import java.io.*;
import java.util.*;

public class boj2230 {
    static int N, M, minDiff;
    static int arr[];

    public static void twoPointer() {
        int pi, pj;

        pi = 0;
        pj = 0;

        if (N <= 1) {
            return;
        }

        while (pi < N) {
            if (arr[pi] - arr[pj] < M) {
                pi++;
                continue;
            }

            if (arr[pi] - arr[pj] == M) {
                minDiff = M;
                return;
            }

            minDiff = Math.min(minDiff, arr[pi] - arr[pj]);
            pj++;
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        twoPointer();
        System.out.println(minDiff == Integer.MAX_VALUE ? 0 : minDiff);
    }
}
