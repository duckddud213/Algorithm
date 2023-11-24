import java.io.*;
import java.util.*;

public class boj2568 {
    static int N;
    static int dp[],index[];
    static int stand[][];
    static StringBuilder sb;

    public static int findMax(int src, int dest, int num) {
        if (src == dest) {
            return src;
        }
        int m = (src + dest) / 2;

        if (dp[m] <= num) {
            return findMax(src, m, num);
        }
        return findMax(m + 1, dest, num);
    }
    
    public static void LIS() {
        int len,idx;

        len = 1;
        dp[1] = stand[N-1][1];
        index[N - 1] = 1;

        for (int i = N - 2; i >= 0; i--) {
            if (stand[i][1] < dp[len]) {
                dp[++len] = stand[i][1];
                index[i] = len;
            } else {
                idx = findMax(1, len, stand[i][1]);
                dp[idx] = stand[i][1];
                index[i] = idx;
            }
        }
        
        sb.append(N - len).append('\n');

        idx = len;
        for (int i = 0; i < N; i++) {
            if (index[i] == idx) {
                idx--;
            }
            else {
                sb.append(stand[i][0]).append('\n');
            }
        }
    }

    public static void pre() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        stand = new int[N][2];
        dp = new int[N + 1];
        index = new int[N];
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            stand[i][0] = Integer.parseInt(st.nextToken());
            stand[i][1] = Integer.parseInt(st.nextToken());
        }

        // Arrays.sort(stand[0]);

        Arrays.sort(stand, (o1, o2) -> o1[0] - o2[0]);
    }
    
    public static void main(String args[]) throws IOException {
        pre();
        LIS();
        System.out.println(sb);
    }
}
