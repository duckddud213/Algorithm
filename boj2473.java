import java.io.*;
import java.util.*;

public class boj2473 {
    static int N, p1, p2, p3;
    static long sum,min;
    static long liquid[];

    public static void twoPointer() {
        int l, r;

        for (int m = 0; m < N - 2; m++) {
            l = m + 1;
            r = N - 1;

            while (l < r) {
                sum = liquid[m] + liquid[l] + liquid[r];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    p1 = m;
                    p2 = l;
                    p3 = r;
                }
                if (sum == 0) {
                    p1 = m;
                    p2 = l;
                    p3 = r;
                    return;
                }
                else if (sum > 0) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
    }
    
    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        min = Long.MAX_VALUE;
        p1 = 0;
        p2 = 0;
        p3 = 0;

        liquid = new long[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        twoPointer();
        System.out.println(liquid[p1] + " " + liquid[p2] + " " + liquid[p3]);
    }
}