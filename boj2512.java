import java.io.*;
import java.util.*;

public class boj2512 {
    static int N;
    static long l, r, mid, total, result;
    static int cost[];

    public static void binarySearch() {

        while (l <= r) {
            mid = (l + r) / 2;
            result = 0;

            for (int i = 0; i < N; i++) {
                result += ((cost[i] > mid) ? mid : cost[i]);
            }

            if (result <= total) {
                l = mid + 1;
            } 
            else {
                r = mid - 1;
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        cost = new int[N];
        l = 0;
        r = 0;

        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());

            r = Long.max(r, cost[i]);
        }

        total = Long.parseLong(br.readLine());
    }

    public static void main(String args[]) throws IOException {
        pre();
        binarySearch();
        System.out.println(r);
    }
}
